package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Location
import org.bukkit.WorldBorder
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.concurrent.TimeUnit

object FnWorldBorder {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldBorder::class.java)
                .function("world", 0) { it.target?.world }
                .function("reset", 0) { it.target?.reset() }
                .function("size", 0) { it.target?.size }
                .function("setSize", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> it.target?.setSize(it.getNumber(0).toDouble())
                        2 -> it.target?.setSize(it.getNumber(0).toDouble(), it.getNumber(1).toLong())
                        3 -> it.target?.setSize(
                            it.getNumber(0).toDouble(),
                            it.getArgument(1) as TimeUnit,
                            it.getNumber(2).toLong()
                        )
                        else -> error("WorldBorder#setSize 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("center", 0) { it.target?.center }
                .function("setCenter", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setCenter(it.getArgument(0) as Location)
                    } else {
                        it.target?.setCenter(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble()
                        )
                    }
                }
                .function("damageBuffer", 0) { it.target?.damageBuffer }
                .function("setDamageBuffer", 1) { it.target?.setDamageBuffer(it.getNumber(0).toDouble()) }
                .function("damageAmount", 0) { it.target?.damageAmount }
                .function("setDamageAmount", 1) { it.target?.setDamageAmount(it.getNumber(0).toDouble()) }
                .function("warningTime", 0) { it.target?.warningTime }
                .function("setWarningTime", 1) { it.target?.setWarningTime(it.getNumber(0).toInt()) }
                .function("warningDistance", 0) { it.target?.warningDistance }
                .function("setWarningDistance", 1) { it.target?.setWarningDistance(it.getNumber(0).toInt()) }
                .function("isInside", 1) { it.target?.isInside(it.getArgument(0) as Location) }
                .function("maxSize", 0) { it.target?.maxSize }
                .function("maxCenterCoordinate", 0) { it.target?.maxCenterCoordinate }
        }
    }
}
