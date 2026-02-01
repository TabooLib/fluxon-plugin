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
            registerExtension(Color::class.java)
                // static
                .function("fromARGB", returnsObject().params(Type.I)) {
                    it.setReturnRef(Color.fromARGB(it.getInt(0).toInt()))
                }
                .function("fromARGB", returnsObject().params(Type.I, Type.I, Type.I, Type.I)) {
                    it.setReturnRef(Color.fromARGB(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ))
                }
                // static
                .function("fromRGB", returnsObject().params(Type.I)) {
                    it.setReturnRef(Color.fromRGB(it.getInt(0).toInt()))
                }
                .function("fromRGB", returnsObject().params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(Color.fromRGB(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                // static
                .function("fromBGR", returnsObject().params(Type.I)) {
                    it.setReturnRef(Color.fromBGR(it.getInt(0).toInt()))
                }
                .function("fromBGR", returnsObject().params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(Color.fromBGR(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ))
                }
                .function("alpha", returns(Type.I).noParams()) { it.setReturnInt(it.target?.alpha ?: 0) }
                .function("setAlpha", returnsObject().params(Type.I)) { it.setReturnRef(it.target?.setAlpha(it.getInt(0).toInt())) }
                .function("red", returns(Type.I).noParams()) { it.setReturnInt(it.target?.red ?: 0) }
                .function("setRed", returnsObject().params(Type.I)) { it.setReturnRef(it.target?.setRed(it.getInt(0).toInt())) }
                .function("green", returns(Type.I).noParams()) { it.setReturnInt(it.target?.green ?: 0) }
                .function("setGreen", returnsObject().params(Type.I)) { it.setReturnRef(it.target?.setGreen(it.getInt(0).toInt())) }
                .function("blue", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blue ?: 0) }
                .function("setBlue", returnsObject().params(Type.I)) { it.setReturnRef(it.target?.setBlue(it.getInt(0).toInt())) }
                .function("asRGB", returns(Type.I).noParams()) { it.setReturnInt(it.target?.asRGB() ?: 0) }
                .function("asARGB", returns(Type.I).noParams()) { it.setReturnInt(it.target?.asARGB() ?: 0) }
                .function("asBGR", returns(Type.I).noParams()) { it.setReturnInt(it.target?.asBGR() ?: 0) }
                .function("mixDyes", returnsObject().noParams()) { it.setReturnRef(it.target?.mixDyes()) }
                .function("mixColors", returnsObject().noParams()) { it.setReturnRef(it.target?.mixColors()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.equals(it.getRef(0)) ?: false) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnInt(it.target?.hashCode() ?: 0) }
                // static
                .function("deserialize", returnsObject().params(Type.MAP)) { it.setReturnRef(Color.deserialize(it.getRef(0) as Map<String, Any>)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
