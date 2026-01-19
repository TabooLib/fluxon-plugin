package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.NumberConversions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnNumberConversions {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NumberConversions::class.java)
                // static
                .function("floor", 1) { NumberConversions.floor(it.getNumber(0).toDouble()) }
                // static
                .function("ceil", 1) { NumberConversions.ceil(it.getNumber(0).toDouble()) }
                // static
                .function("round", 1) { NumberConversions.round(it.getNumber(0).toDouble()) }
                // static
                .function("square", 1) { NumberConversions.square(it.getNumber(0).toDouble()) }
                // static
                .function("toInt", 1) { NumberConversions.toInt(it.getArgument(0)) }
                // static
                .function("toFloat", 1) { NumberConversions.toFloat(it.getArgument(0)) }
                // static
                .function("toDouble", 1) { NumberConversions.toDouble(it.getArgument(0)) }
                // static
                .function("toLong", 1) { NumberConversions.toLong(it.getArgument(0)) }
                // static
                .function("toShort", 1) { NumberConversions.toShort(it.getArgument(0)) }
                // static
                .function("toByte", 1) { NumberConversions.toByte(it.getArgument(0)) }
                // static
                .function("isFinite", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Double -> NumberConversions.isFinite(var1)
                        is Float -> NumberConversions.isFinite(var1)
                        else -> throw IllegalArgumentException("参数必须是 Double 或 Float 类型")
                    }
                }
                // static
                .function("checkFinite", 2) {
                    when (val var1 = it.getArgument(0)) {
                        is Double -> NumberConversions.checkFinite(var1, it.getString(1)!!)
                        is Float -> NumberConversions.checkFinite(var1, it.getString(1)!!)
                        else -> throw IllegalArgumentException("第一个参数必须是 Double 或 Float 类型")
                    }
                }
        }
    }
}
