package org.tabooproject.fluxon.util

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.error.*
import taboolib.common.platform.function.warning
import java.util.concurrent.CompletableFuture

/**
 * 处理 CompletableFuture 中的 FluxonRuntimeError 异常
 */
fun Any.exceptFluxonCompletableFutureError() {
    if (this is CompletableFuture<*>) {
        this.exceptionally { ex ->
            if (ex is FluxonRuntimeError) {
                ex.printError()
            }
            null
        }
    }
}

fun FluxonRuntimeError.printError() {
    warning(message)
    when (this) {
        // 参数类型错误
        is ArgumentTypeMismatchError -> {
            if (actual == null) {
                warning("函数 ${context.function.name} 的第 ${index + 1} 个参数为空")
            } else {
                warning("函数 ${context.function.name} 的第 ${index + 1} 个参数类型错误")
                warning("实际: ${actual.javaClass.simpleName} ($actual)")
            }
            warning("期望: ${expect.simpleName}")
        }
        // 函数未找到
        is FunctionNotFoundError -> {
            warning("没有找到函数: $name (pos: $pos,$exPos)")
            // 打印目标
            if (target != null) {
                warning("目标: $target (${target.javaClass})")
                val find = hashSetOf<String>()
                FluxonRuntime.getInstance().extensionFunctions.forEach { (_, overloadSet) ->
                    overloadSet.forEach { (type, overload) ->
                        if (type.isAssignableFrom(javaClass)) {
                            find += overload.name
                        }
                    }
                }
                warning("目标支持的扩展函数: $find")
            } else {
                warning("目标为空")
            }
        }
        // 索引访问错误
        is IndexAccessError -> {
            warning("索引访问错误: $errorType")
            warning("目标: $target (${target.javaClass})")
            warning("索引: $index")
        }
        // 变量未找到
        is VariableNotFoundError -> {
            warning("没有找到变量: $variableName (index: $index)")
            warning("可用: $availableVariables")
        }
    }
}