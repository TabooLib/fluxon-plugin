package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Color
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnColor {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Color::class.java)
                // static
                .function("fromARGB", listOf(1, 4)) {
                    if (it.arguments.size == 1) {
                        Color.fromARGB(it.getNumber(0).toInt())
                    } else {
                        Color.fromARGB(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }
                // static
                .function("fromRGB", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        Color.fromRGB(it.getNumber(0).toInt())
                    } else {
                        Color.fromRGB(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                // static
                .function("fromBGR", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        Color.fromBGR(it.getNumber(0).toInt())
                    } else {
                        Color.fromBGR(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                .function("alpha", 0) { it.target?.alpha }
                .function("setAlpha", 1) { it.target?.setAlpha(it.getNumber(0).toInt()) }
                .function("red", 0) { it.target?.red }
                .function("setRed", 1) { it.target?.setRed(it.getNumber(0).toInt()) }
                .function("green", 0) { it.target?.green }
                .function("setGreen", 1) { it.target?.setGreen(it.getNumber(0).toInt()) }
                .function("blue", 0) { it.target?.blue }
                .function("setBlue", 1) { it.target?.setBlue(it.getNumber(0).toInt()) }
                .function("asRGB", 0) { it.target?.asRGB() }
                .function("asARGB", 0) { it.target?.asARGB() }
                .function("asBGR", 0) { it.target?.asBGR() }
                .function("mixDyes", 0) { it.target?.mixDyes() }
                .function("mixColors", 0) { it.target?.mixColors() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("hashCode", 0) { it.target?.hashCode() }
                // static
                .function("deserialize", 1) { Color.deserialize(it.getArgument(0) as Map<String, Any>) }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
