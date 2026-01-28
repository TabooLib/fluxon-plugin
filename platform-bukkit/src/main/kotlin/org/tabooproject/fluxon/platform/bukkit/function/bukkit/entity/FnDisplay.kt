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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Display"])
@PlatformSide(Platform.BUKKIT)
object FnDisplay {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Display::class.java)
                .function("transformation", returnsObject().noParams()) { it.setReturnRef(it.target?.transformation) }
                .function("setTransformation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTransformation(it.getRef(0) as Transformation)) }
                .function("interpolationDuration", returnsObject().noParams()) { it.setReturnRef(it.target?.interpolationDuration) }
                .function("setInterpolationDuration", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.setInterpolationDuration(
                        it.getInt(0).toInt()
                    ))
                }
                .function("teleportDuration", returnsObject().noParams()) { it.setReturnRef(it.target?.teleportDuration) }
                .function("setTeleportDuration", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTeleportDuration(it.getInt(0).toInt())) }
                .function("viewRange", returnsObject().noParams()) { it.setReturnRef(it.target?.viewRange) }
                .function("setViewRange", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setViewRange(it.getFloat(0))) }
                .function("shadowRadius", returnsObject().noParams()) { it.setReturnRef(it.target?.shadowRadius) }
                .function("setShadowRadius", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setShadowRadius(it.getFloat(0))) }
                .function("shadowStrength", returnsObject().noParams()) { it.setReturnRef(it.target?.shadowStrength) }
                .function("setShadowStrength", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setShadowStrength(it.getFloat(0))) }
                .function("displayWidth", returnsObject().noParams()) { it.setReturnRef(it.target?.displayWidth) }
                .function("setDisplayWidth", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDisplayWidth(it.getFloat(0))) }
                .function("displayHeight", returnsObject().noParams()) { it.setReturnRef(it.target?.displayHeight) }
                .function("setDisplayHeight", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDisplayHeight(it.getFloat(0))) }
                .function("interpolationDelay", returnsObject().noParams()) { it.setReturnRef(it.target?.interpolationDelay) }
                .function("setInterpolationDelay", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setInterpolationDelay(it.getInt(0).toInt())) }
                .function("billboard", returnsObject().noParams()) { it.setReturnRef(it.target?.billboard) }
                .function("setBillboard", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBillboard(it.getRef(0) as Display.Billboard)) }
                .function("glowColorOverride", returnsObject().noParams()) { it.setReturnRef(it.target?.glowColorOverride) }
                .function("setGlowColorOverride", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setGlowColorOverride(it.getRef(0) as Color)) }
                .function("brightness", returnsObject().noParams()) { it.setReturnRef(it.target?.brightness) }
                .function("setBrightness", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBrightness(it.getRef(0) as Display.Brightness)) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Display.Brightness"])
@PlatformSide(Platform.BUKKIT)
object FnDisplayBrightness {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Display.Brightness::class.java)
                .function("blockLight", returnsObject().noParams()) { it.setReturnRef(it.target?.blockLight) }
                .function("skyLight", returnsObject().noParams()) { it.setReturnRef(it.target?.skyLight) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
