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
                .function("transformation", returnsObject().noParams()) { it.target?.transformation }
                .function("setTransformation", returnsObject().params(Type.OBJECT)) { it.target?.setTransformation(it.getRef(0) as Transformation) }
                .function("interpolationDuration", returnsObject().noParams()) { it.target?.interpolationDuration }
                .function("setInterpolationDuration", returnsObject().params(Type.OBJECT)) {
                    it.target?.setInterpolationDuration(
                        it.getInt(0).toInt()
                    )
                }
                .function("teleportDuration", returnsObject().noParams()) { it.target?.teleportDuration }
                .function("setTeleportDuration", returnsObject().params(Type.OBJECT)) { it.target?.setTeleportDuration(it.getInt(0).toInt()) }
                .function("viewRange", returnsObject().noParams()) { it.target?.viewRange }
                .function("setViewRange", returnsObject().params(Type.OBJECT)) { it.target?.setViewRange(it.getFloat(0)) }
                .function("shadowRadius", returnsObject().noParams()) { it.target?.shadowRadius }
                .function("setShadowRadius", returnsObject().params(Type.OBJECT)) { it.target?.setShadowRadius(it.getFloat(0)) }
                .function("shadowStrength", returnsObject().noParams()) { it.target?.shadowStrength }
                .function("setShadowStrength", returnsObject().params(Type.OBJECT)) { it.target?.setShadowStrength(it.getFloat(0)) }
                .function("displayWidth", returnsObject().noParams()) { it.target?.displayWidth }
                .function("setDisplayWidth", returnsObject().params(Type.OBJECT)) { it.target?.setDisplayWidth(it.getFloat(0)) }
                .function("displayHeight", returnsObject().noParams()) { it.target?.displayHeight }
                .function("setDisplayHeight", returnsObject().params(Type.OBJECT)) { it.target?.setDisplayHeight(it.getFloat(0)) }
                .function("interpolationDelay", returnsObject().noParams()) { it.target?.interpolationDelay }
                .function("setInterpolationDelay", returnsObject().params(Type.OBJECT)) { it.target?.setInterpolationDelay(it.getInt(0).toInt()) }
                .function("billboard", returnsObject().noParams()) { it.target?.billboard }
                .function("setBillboard", returnsObject().params(Type.OBJECT)) { it.target?.setBillboard(it.getRef(0) as Display.Billboard) }
                .function("glowColorOverride", returnsObject().noParams()) { it.target?.glowColorOverride }
                .function("setGlowColorOverride", returnsObject().params(Type.OBJECT)) { it.target?.setGlowColorOverride(it.getRef(0) as Color) }
                .function("brightness", returnsObject().noParams()) { it.target?.brightness }
                .function("setBrightness", returnsObject().params(Type.OBJECT)) { it.target?.setBrightness(it.getRef(0) as Display.Brightness) }
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
                .function("blockLight", returnsObject().noParams()) { it.target?.blockLight }
                .function("skyLight", returnsObject().noParams()) { it.target?.skyLight }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
        }
    }
}
