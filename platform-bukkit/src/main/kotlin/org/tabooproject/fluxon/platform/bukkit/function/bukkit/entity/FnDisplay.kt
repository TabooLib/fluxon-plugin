package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Color
import org.bukkit.entity.Display
import org.bukkit.util.Transformation
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnDisplay {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Display::class.java)
                .function("transformation", 0) { it.target?.transformation }
                .function("setTransformation", 1) { it.target?.setTransformation(it.getArgument(0) as Transformation) }
                .function("interpolationDuration", 0) { it.target?.interpolationDuration }
                .function("setInterpolationDuration", 1) {
                    it.target?.setInterpolationDuration(
                        it.getNumber(0).toInt()
                    )
                }
                .function("teleportDuration", 0) { it.target?.teleportDuration }
                .function("setTeleportDuration", 1) { it.target?.setTeleportDuration(it.getNumber(0).toInt()) }
                .function("viewRange", 0) { it.target?.viewRange }
                .function("setViewRange", 1) { it.target?.setViewRange(it.getNumber(0).toFloat()) }
                .function("shadowRadius", 0) { it.target?.shadowRadius }
                .function("setShadowRadius", 1) { it.target?.setShadowRadius(it.getNumber(0).toFloat()) }
                .function("shadowStrength", 0) { it.target?.shadowStrength }
                .function("setShadowStrength", 1) { it.target?.setShadowStrength(it.getNumber(0).toFloat()) }
                .function("displayWidth", 0) { it.target?.displayWidth }
                .function("setDisplayWidth", 1) { it.target?.setDisplayWidth(it.getNumber(0).toFloat()) }
                .function("displayHeight", 0) { it.target?.displayHeight }
                .function("setDisplayHeight", 1) { it.target?.setDisplayHeight(it.getNumber(0).toFloat()) }
                .function("interpolationDelay", 0) { it.target?.interpolationDelay }
                .function("setInterpolationDelay", 1) { it.target?.setInterpolationDelay(it.getNumber(0).toInt()) }
                .function("billboard", 0) { it.target?.billboard }
                .function("setBillboard", 1) { it.target?.setBillboard(it.getArgument(0) as Display.Billboard) }
                .function("glowColorOverride", 0) { it.target?.glowColorOverride }
                .function("setGlowColorOverride", 1) { it.target?.setGlowColorOverride(it.getArgument(0) as Color) }
                .function("brightness", 0) { it.target?.brightness }
                .function("setBrightness", 1) { it.target?.setBrightness(it.getArgument(0) as Display.Brightness) }

            registerExtension(Display.Brightness::class.java)
                .function("blockLight", 0) { it.target?.blockLight }
                .function("skyLight", 0) { it.target?.skyLight }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
