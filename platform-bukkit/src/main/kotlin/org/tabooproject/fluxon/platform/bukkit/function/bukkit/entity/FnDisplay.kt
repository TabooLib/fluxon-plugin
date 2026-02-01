package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Color
import org.bukkit.entity.Display
import org.bukkit.util.Transformation
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Display"])
@PlatformSide(Platform.BUKKIT)
object FnDisplay {

    val TYPE = Type.fromClass(Display::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Display::class.java)
                .function("transformation", returnsObject().noParams()) { it.setReturnRef(it.target?.transformation) }
                .function("setTransformation", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setTransformation(it.getRef(0) as Transformation)
                }
                .function("interpolationDuration", returns(Type.I).noParams()) {
                    it.setReturnInt(it.target?.interpolationDuration ?: 0)
                }
                .function("setInterpolationDuration", returnsVoid().params(Type.I)) {
                    it.target?.setInterpolationDuration(it.getInt(0).toInt())
                }
                .function("teleportDuration", returns(Type.I).noParams()) { it.setReturnInt(it.target?.teleportDuration ?: 0) }
                .function("setTeleportDuration", returnsVoid().params(Type.I)) {
                    it.target?.setTeleportDuration(it.getInt(0).toInt())
                }
                .function("viewRange", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.viewRange ?: 0.0f) }
                .function("setViewRange", returnsVoid().params(Type.F)) { it.target?.setViewRange(it.getFloat(0)) }
                .function("shadowRadius", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.shadowRadius ?: 0.0f) }
                .function("setShadowRadius", returnsVoid().params(Type.F)) { it.target?.setShadowRadius(it.getFloat(0)) }
                .function("shadowStrength", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.shadowStrength ?: 0.0f) }
                .function("setShadowStrength", returnsVoid().params(Type.F)) { it.target?.setShadowStrength(it.getFloat(0)) }
                .function("displayWidth", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.displayWidth ?: 0.0f) }
                .function("setDisplayWidth", returnsVoid().params(Type.F)) { it.target?.setDisplayWidth(it.getFloat(0)) }
                .function("displayHeight", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.displayHeight ?: 0.0f) }
                .function("setDisplayHeight", returnsVoid().params(Type.F)) { it.target?.setDisplayHeight(it.getFloat(0)) }
                .function("interpolationDelay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.interpolationDelay ?: 0) }
                .function("setInterpolationDelay", returnsVoid().params(Type.I)) {
                    it.target?.setInterpolationDelay(it.getInt(0).toInt())
                }
                .function("billboard", returnsObject().noParams()) { it.setReturnRef(it.target?.billboard) }
                .function("setBillboard", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setBillboard(it.getRef(0) as Display.Billboard)
                }
                .function("glowColorOverride", returnsObject().noParams()) { it.setReturnRef(it.target?.glowColorOverride) }
                .function("setGlowColorOverride", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setGlowColorOverride(it.getRef(0) as Color)
                }
                .function("brightness", returnsObject().noParams()) { it.setReturnRef(it.target?.brightness) }
                .function("setBrightness", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setBrightness(it.getRef(0) as Display.Brightness)
                }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Display.Brightness"])
@PlatformSide(Platform.BUKKIT)
object FnDisplayBrightness {

    val TYPE = Type.fromClass(Display.Brightness::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Display.Brightness::class.java)
                .function("blockLight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockLight ?: 0) }
                .function("skyLight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.skyLight ?: 0) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnInt(it.target?.hashCode() ?: 0) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.equals(it.getRef(0)) ?: false)
                }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
