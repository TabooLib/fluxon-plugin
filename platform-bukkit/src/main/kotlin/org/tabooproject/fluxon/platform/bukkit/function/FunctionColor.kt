package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.Color
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common5.cint
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FunctionColor {

    @Awake(LifeCycle.LOAD)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            // Color
            registerFunction("color", listOf(1, 3)) {
                when (it.arguments.size) {
                    1 -> {
                        val arg = it.getArgument(0)!!
                        if (arg is String) {
                            val hex = arg.removePrefix("#")
                            val rgb = hex.toInt(16)
                            Color.fromRGB(rgb)
                        } else {
                            Color.fromRGB(arg.cint)
                        }
                    }

                    3 -> {
                        val r = it.getNumber(0).toInt()
                        val g = it.getNumber(1).toInt()
                        val b = it.getNumber(2).toInt()
                        Color.fromRGB(r, g, b)
                    }

                    else -> error("color 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                }
            }

            registerExtension(Color::class.java)
                // 基本属性
                .function("r", 0) {
                    it.target?.red
                }
                .function("g", 0) {
                    it.target?.green
                }
                .function("b", 0) {
                    it.target?.blue
                }

                // 转换为 16 进制颜色
                .function("hex", 0) {
                    String.format("#%06X", it.target?.asRGB() ?: 0)
                }

                // 颜色插值
                .function("lerp", 2) {
                    val fromColor = it.target!!
                    val toColor = it.getArgumentByType(0, Color::class.java)!!
                    val t = it.getNumber(1).toDouble()
                    Color.fromRGB(
                        (fromColor.red + (toColor.red - fromColor.red) * t).toInt(),
                        (fromColor.green + (toColor.green - fromColor.green) * t).toInt(),
                        (fromColor.blue + (toColor.blue - fromColor.blue) * t).toInt()
                    )
                }
        }
    }
}