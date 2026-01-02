package org.tabooproject.fluxon.function.util

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Function
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.warning

object ExtensionDev {

    @Awake(LifeCycle.LOAD)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtensionFunction(Object::class.java, "usage", 0) {
                val javaClass = it.target?.javaClass
                if (javaClass == null) {
                    warning("Target is null")
                } else {
                    val find = arrayListOf<Function>()
                    FluxonRuntime.getInstance().extensionFunctions.forEach { (_, value) ->
                        value.forEach { (type, func) ->
                            if (type.isAssignableFrom(javaClass)) {
                                find += func
                            }
                        }
                    }
                    warning("目标类型: $javaClass 可以使用以下扩展函数:")
                    warning("括号中的数字表示可以接受的参数数量")
                    warning("例如 random [1,2] 表示可以使用 random(num) 或 random(num1, num2)")
                    warning("具体参数类型请查看相关说明文档")
                    find.sortedBy { func -> func.name }.forEach { func ->
                        warning("    ${func.name} ${func.parameterCounts}")
                    }
                }
                null
            }
        }
    }
}