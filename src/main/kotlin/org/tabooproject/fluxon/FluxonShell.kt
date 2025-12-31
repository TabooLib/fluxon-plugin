package org.tabooproject.fluxon

import org.tabooproject.fluxon.interpreter.Interpreter
import org.tabooproject.fluxon.interpreter.ReturnValue
import org.tabooproject.fluxon.parser.ParseResult
import org.tabooproject.fluxon.parser.error.ParseException
import org.tabooproject.fluxon.runtime.Environment
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.error.FluxonRuntimeError
import org.tabooproject.fluxon.util.SimpleCache
import org.tabooproject.fluxon.util.printError
import taboolib.common.platform.function.warning

object FluxonShell {

    val scriptCache = SimpleCache<String, List<ParseResult>>(
        expireAfterAccessMs = 60 * 60 * 1000, // 1小时
        maxSize = 100
    )

    /**
     * 解释脚本但不执行
     */
    fun parse(script: String, env: Environment.() -> Unit = {}): ParseScript {
        return ParseScript(parse(script, FluxonRuntime.getInstance().newEnvironment().also(env)))
    }

    /**
     * 执行脚本
     *
     * @param script      脚本文本
     * @param useCache    是否使用缓存，如果脚本修改频繁建议不使用缓存
     * @param env         脚本执行环境
     */
    fun invoke(script: String, useCache: Boolean = true, env: Environment.() -> Unit = {}): Any? {
        // 构建脚本环境
        val environment = FluxonRuntime.getInstance().newEnvironment().also(env)
        // 解析脚本（如果有缓存则跳过解析过程）
        val parsed = if (useCache) {
            scriptCache.get(script) { parse(script, environment) }
        } else {
            parse(script, environment)
        }
        return invoke(parsed, environment)
    }

    /**
     * 执行已解析的脚本
     *
     * @param parsed      已解析的脚本
     * @param environment 脚本执行环境
     */
    fun invoke(parsed: List<ParseResult>, environment: Environment): Any? {
        val interpreter = Interpreter(environment)
        return try {
            interpreter.execute(parsed)
        } catch (ex: ReturnValue) {
            ex.value
        } catch (ex: FluxonRuntimeError) {
            ex.printError()
            null
        }
    }

    fun parse(script: String, environment: Environment): List<ParseResult> {
        return try {
            Fluxon.parse(script.removePrefix(";"), environment)
        } catch (ex: ParseException) {
            warning("解析脚本 $script 时发生错误:\n${ex.formatDiagnostic()}")
            emptyList()
        }
    }
}