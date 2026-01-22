package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Color
import org.bukkit.DyeColor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDyeColor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DyeColor::class.java)
                .function("woolData", 0) { it.target?.woolData }
                .function("dyeData", 0) { it.target?.dyeData }
                .function("color", 0) { it.target?.color }
                .function("fireworkColor", 0) { it.target?.fireworkColor }
                // static
                .function("getByWoolData", 1) { DyeColor.getByWoolData(it.getNumber(0).toByte()) }
                // static
                .function("getByDyeData", 1) { DyeColor.getByDyeData(it.getNumber(0).toByte()) }
                // static
                .function("getByColor", 1) { DyeColor.getByColor(it.getArgument(0) as Color) }
                // static
                .function("getByFireworkColor", 1) { DyeColor.getByFireworkColor(it.getArgument(0) as Color) }
                // static
                .function("legacyValueOf", 1) { DyeColor.legacyValueOf(it.getString(0)) }
        }
    }
}
