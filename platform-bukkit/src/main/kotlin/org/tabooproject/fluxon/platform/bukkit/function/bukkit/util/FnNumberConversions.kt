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
                    // static boolean isFinite(double d)
                    // static boolean isFinite(float f)
                    TODO()
                }
                // static
                .function("checkFinite", 2) {
                    // static void checkFinite(double d, @NotNull String message)
                    // static void checkFinite(float d, @NotNull String message)
                    TODO()
                }
        }
    }
}
