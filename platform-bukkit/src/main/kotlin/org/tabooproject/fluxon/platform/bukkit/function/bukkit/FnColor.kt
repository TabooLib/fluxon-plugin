package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Color
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.Color"])
@PlatformSide(Platform.BUKKIT)
object FnColor {

    val TYPE = Type.fromClass(Color::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            // Color - 单参数版本 (hex string 或 int)
            registerFunction("color", returns(FnColor.TYPE).params(Type.STRING)) {
                val hex = it.getString(0)!!.removePrefix("#")
                it.setReturnRef(Color.fromRGB(hex.toInt(16)))}
            registerFunction("color", returns(FnColor.TYPE).params(Type.I)) { it.setReturnRef(Color.fromRGB(it.getInt(0))) }
            // Color - RGB 三参数版本
            registerFunction("color", returns(FnColor.TYPE).params(Type.I, Type.I, Type.I)) { it.setReturnRef(Color.fromRGB(it.getInt(0), it.getInt(1), it.getInt(2))) }
            registerExtension(Color::class.java)
                // 基本属性
                .function("r", returns(Type.I).noParams()) { it.setReturnRef(it.target?.red) }
                .function("g", returns(Type.I).noParams()) { it.setReturnRef(it.target?.green) }
                .function("b", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blue) }
                // 转换为 16 进制颜色
                .function("hex", returns(Type.STRING).noParams()) { it.setReturnRef(String.format("#%06X", it.target?.asRGB() ?: 0)) }
                // 颜色插值
                .function("lerp", returns(FnColor.TYPE).params(Type.OBJECT, Type.D)) {
                    val fromColor = it.target!!
                    val toColor = it.getRef(0) as Color
                    val t = it.getDouble(1)
                    it.setReturnRef(Color.fromRGB(
                        (fromColor.red + (toColor.red - fromColor.red) * t).toInt(),
                        (fromColor.green + (toColor.green - fromColor.green) * t).toInt(),
                        (fromColor.blue + (toColor.blue - fromColor.blue) * t).toInt()
                    ))
                }
        }
        with(FluxonRuntime.getInstance()) {
            registerExtension(Color::class.java)
                // static
                .function("fromARGB",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I)) {
                    it.setReturnRef(Color.fromARGB(it.getInt(0).toInt()))
                }
                .function("fromARGB",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I, Type.I, Type.I, Type.I)) {
                    it.setReturnRef(Color.fromARGB(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ))
                }
                // static
                .function("fromRGB",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I)) {
                    it.setReturnRef(Color.fromRGB(it.getInt(0).toInt()))
                }
                .function("fromRGB",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(Color.fromRGB(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                // static
                .function("fromBGR",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I)) {
                    it.setReturnRef(Color.fromBGR(it.getInt(0).toInt()))
                }
                .function("fromBGR",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(Color.fromBGR(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("alpha", returns(Type.I).noParams()) { it.setReturnInt(it.target?.alpha ?: 0) }
                .function("setAlpha",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I)) { it.setReturnRef(it.target?.setAlpha(it.getInt(0).toInt())) }
                .function("red", returns(Type.I).noParams()) { it.setReturnInt(it.target?.red ?: 0) }
                .function("setRed",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I)) { it.setReturnRef(it.target?.setRed(it.getInt(0).toInt())) }
                .function("green", returns(Type.I).noParams()) { it.setReturnInt(it.target?.green ?: 0) }
                .function("setGreen",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I)) { it.setReturnRef(it.target?.setGreen(it.getInt(0).toInt())) }
                .function("blue", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blue ?: 0) }
                .function("setBlue",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.I)) { it.setReturnRef(it.target?.setBlue(it.getInt(0).toInt())) }
                .function("asRGB", returns(Type.I).noParams()) { it.setReturnInt(it.target?.asRGB() ?: 0) }
                .function("asARGB", returns(Type.I).noParams()) { it.setReturnInt(it.target?.asARGB() ?: 0) }
                .function("asBGR", returns(Type.I).noParams()) { it.setReturnInt(it.target?.asBGR() ?: 0) }
                .function("mixDyes", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.mixDyes()) }
                .function("mixColors", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.mixColors()) }
                // static
                .function("deserialize",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).params(Type.MAP)) { it.setReturnRef(Color.deserialize(it.getRef(0) as Map<String, Any>)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
