package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapPalette
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.awt.Image
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMapPalette {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapPalette::class.java)
                // static
                .function("resizeImage", 1) { MapPalette.resizeImage(it.getArgument(0) as Image) }
                // static
                .function("imageToBytes", 1) { MapPalette.imageToBytes(it.getArgument(0) as Image) }
                // static
                .function("matchColor", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        MapPalette.matchColor(it.getArgument(0) as java.awt.Color)
                    } else {
                        MapPalette.matchColor(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt()
                        )
                    }
                }
                // static
                .function("getColor", 1) { MapPalette.getColor(it.getNumber(0).toByte()) }
                // static
                .function(
                    "setMapColorCache",
                    1
                ) { MapPalette.setMapColorCache(it.getArgument(0) as MapPalette.MapColorCache) }

            registerExtension(MapPalette.MapColorCache::class.java)
                .function("isCached", 0) { it.target?.isCached }
        }
    }
}
