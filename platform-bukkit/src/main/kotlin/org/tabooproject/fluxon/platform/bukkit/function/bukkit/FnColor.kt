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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Color::class.java)
                // static
                .function("fromARGB", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        Color.fromARGB(it.getInt(0).toInt())
                    } else {
                        Color.fromARGB(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt()
                        )
                    })
                }
                .function("fromARGB", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        Color.fromARGB(it.getInt(0).toInt())
                    } else {
                        Color.fromARGB(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt()
                        )
                    })
                }
                // static
                .function("fromRGB", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        Color.fromRGB(it.getInt(0).toInt())
                    } else {
                        Color.fromRGB(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("fromRGB", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        Color.fromRGB(it.getInt(0).toInt())
                    } else {
                        Color.fromRGB(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                // static
                .function("fromBGR", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        Color.fromBGR(it.getInt(0).toInt())
                    } else {
                        Color.fromBGR(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("fromBGR", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        Color.fromBGR(it.getInt(0).toInt())
                    } else {
                        Color.fromBGR(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("alpha", returnsObject().noParams()) { it.setReturnRef(it.target?.alpha) }
                .function("setAlpha", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAlpha(it.getInt(0).toInt())) }
                .function("red", returnsObject().noParams()) { it.setReturnRef(it.target?.red) }
                .function("setRed", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRed(it.getInt(0).toInt())) }
                .function("green", returnsObject().noParams()) { it.setReturnRef(it.target?.green) }
                .function("setGreen", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setGreen(it.getInt(0).toInt())) }
                .function("blue", returnsObject().noParams()) { it.setReturnRef(it.target?.blue) }
                .function("setBlue", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBlue(it.getInt(0).toInt())) }
                .function("asRGB", returnsObject().noParams()) { it.setReturnRef(it.target?.asRGB()) }
                .function("asARGB", returnsObject().noParams()) { it.setReturnRef(it.target?.asARGB()) }
                .function("asBGR", returnsObject().noParams()) { it.setReturnRef(it.target?.asBGR()) }
                .function("mixDyes", returnsObject().noParams()) { it.setReturnRef(it.target?.mixDyes()) }
                .function("mixColors", returnsObject().noParams()) { it.setReturnRef(it.target?.mixColors()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                // static
                .function("deserialize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(Color.deserialize(it.getRef(0) as Map<String, Any>)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
