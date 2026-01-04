package org.tabooproject.fluxon.profiler

import jdk.jfr.consumer.RecordedEvent
import jdk.jfr.consumer.RecordingFile
import java.nio.file.Path
import kotlin.math.roundToInt

/**
 * Fluxon 性能分析器
 */
object FluxonProfiler {

    /**
     * 统计数据
     */
    data class Statistics(
        val count: Int,
        val min: Long,
        val max: Long,
        val mean: Double,
        val median: Long,
        val p95: Long,
        val p99: Long,
        val total: Long
    ) {
        fun format(): String = buildString {
            appendLine("执行次数: $count")
            appendLine("最小耗时: ${min}ms")
            appendLine("最大耗时: ${max}ms")
            appendLine("平均耗时: ${"%.2f".format(mean)}ms")
            appendLine("中位数:   ${median}ms")
            appendLine("P95:     ${p95}ms")
            appendLine("P99:     ${p99}ms")
            appendLine("总耗时:   ${total}ms")
        }
    }

    /**
     * 事件统计
     */
    data class EventStats(
        val eventType: String,
        val count: Int,
        val totalDuration: Long,
        val avgDuration: Double,
        val details: Map<String, Any> = emptyMap()
    )

    /**
     * 计算统计数据
     */
    fun calculateStats(durations: List<Long>): Statistics {
        if (durations.isEmpty()) {
            return Statistics(0, 0, 0, 0.0, 0, 0, 0, 0)
        }
        val sorted = durations.sorted()
        val count = sorted.size
        val min = sorted.first()
        val max = sorted.last()
        val total = sorted.sum()
        val mean = total.toDouble() / count
        val median = sorted[count / 2]
        val p95 = sorted[(count * 0.95).roundToInt().coerceAtMost(count - 1)]
        val p99 = sorted[(count * 0.99).roundToInt().coerceAtMost(count - 1)]
        return Statistics(count, min, max, mean, median, p95, p99, total)
    }

    /**
     * 分析 JFR 文件
     */
    fun analyzeJfrFile(jfrFile: Path): Map<String, List<RecordedEvent>> {
        val events = mutableMapOf<String, MutableList<RecordedEvent>>()
        
        RecordingFile(jfrFile).use { recording ->
            while (recording.hasMoreEvents()) {
                val event = recording.readEvent()
                if (event.eventType.name.startsWith("fluxon.")) {
                    events.getOrPut(event.eventType.name) { mutableListOf() }.add(event)
                }
            }
        }
        
        return events
    }

    /**
     * 生成事件统计报告
     */
    fun generateEventReport(events: Map<String, List<RecordedEvent>>): List<EventStats> {
        return events.map { (eventType, eventList) ->
            val durations = eventList.map { it.duration.toMillis() }
            val totalDuration = durations.sum()
            val avgDuration = if (eventList.isNotEmpty()) totalDuration.toDouble() / eventList.size else 0.0
            
            // 根据事件类型提取详细信息
            val details = when (eventType) {
                "fluxon.ScriptExecution" -> {
                    val scriptsCount = eventList.groupBy { it.getString("scriptId") }.size
                    mapOf("uniqueScripts" to scriptsCount)
                }
                "fluxon.InterpreterExecution" -> {
                    val cacheHits = eventList.count { it.getBoolean("cacheHit") }
                    val cacheHitRate = if (eventList.isNotEmpty()) 
                        (cacheHits.toDouble() / eventList.size * 100).roundToInt() 
                    else 0
                    mapOf("cacheHitRate" to "$cacheHitRate%")
                }
                "fluxon.FunctionCall" -> {
                    val topFunctions = eventList
                        .groupBy { it.getString("functionName") }
                        .mapValues { it.value.sumOf { e -> e.duration.toMillis() } }
                        .entries
                        .sortedByDescending { it.value }
                        .take(5)
                    mapOf("topFunctions" to topFunctions.associate { it.key to "${it.value}ms" })
                }
                else -> emptyMap()
            }
            
            EventStats(eventType, eventList.size, totalDuration, avgDuration, details)
        }.sortedByDescending { it.totalDuration }
    }

    /**
     * 格式化事件报告
     */
    fun formatEventReport(stats: List<EventStats>): String = buildString {
        appendLine("\n=== 事件分析报告 ===")
        stats.forEach { stat ->
            val eventName = stat.eventType.removePrefix("fluxon.")
            appendLine("\n[$eventName]")
            appendLine("  调用次数: ${stat.count}")
            appendLine("  总耗时:   ${stat.totalDuration}ms")
            appendLine("  平均耗时: ${"%.2f".format(stat.avgDuration)}ms")
            
            if (stat.details.isNotEmpty()) {
                appendLine("  详细信息:")
                stat.details.forEach { (key, value) ->
                    when (value) {
                        is Map<*, *> -> {
                            appendLine("    $key:")
                            value.forEach { (k, v) -> appendLine("      - $k: $v") }
                        }
                        else -> appendLine("    $key: $value")
                    }
                }
            }
        }
    }
}
