package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.Color
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FunctionColor {

    @Awake(LifeCycle.LOAD)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            // Color - 单参数版本 (hex string 或 int)
            registerFunction("color", returnsObject().params(Type.STRING)) {
                val hex = it.getString(0)!!.removePrefix("#")
                it.setReturnRef(Color.fromRGB(hex.toInt(16)))}
            registerFunction("color", returnsObject().params(Type.I)) { it.setReturnRef(Color.fromRGB(it.getInt(0))) }
            // Color - RGB 三参数版本
            registerFunction("color", returnsObject().params(Type.I, Type.I, Type.I)) { it.setReturnRef(Color.fromRGB(it.getInt(0), it.getInt(1), it.getInt(2))) }
            registerExtension(Color::class.java)
                // 基本属性
                .function("r", returns(Type.I).noParams()) { it.setReturnRef(it.target?.red) }
                .function("g", returns(Type.I).noParams()) { it.setReturnRef(it.target?.green) }
                .function("b", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blue) }
                // 转换为 16 进制颜色
                .function("hex", returns(Type.STRING).noParams()) { it.setReturnRef(String.format("#%06X", it.target?.asRGB() ?: 0)) }
                // 颜色插值
                .function("lerp", returnsObject().params(Type.OBJECT, Type.D)) {
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
    }
}