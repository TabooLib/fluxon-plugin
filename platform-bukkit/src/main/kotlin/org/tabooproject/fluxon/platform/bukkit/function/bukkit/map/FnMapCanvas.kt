package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.Color
import org.bukkit.map.MapCanvas
import org.bukkit.map.MapCursorCollection
import org.bukkit.map.MapFont
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.awt.Image
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMapCanvas {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCanvas::class.java)
                .function("mapView", 0) { it.target?.mapView }
                .function("cursors", 0) { it.target?.cursors }
                .function("setCursors", 1) { it.target?.setCursors(it.getArgument(0) as MapCursorCollection) }
                .function("setPixelColor", 3) {
                    it.target?.setPixelColor(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        (it.getArgument(2) as Color).let { color -> java.awt.Color(color.red, color.green, color.blue) }
                    )
                }
                .function("pixelColor", 2) {
                    it.target?.getPixelColor(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("basePixelColor", 2) {
                    it.target?.getBasePixelColor(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("setPixel", 3) {
                    it.target?.setPixel(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toByte()
                    )
                }
                .function("pixel", 2) { it.target?.getPixel(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("basePixel", 2) { it.target?.getBasePixel(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("drawImage", 3) {
                    it.target?.drawImage(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as Image
                    )
                }
                .function("drawText", 4) {
                    it.target?.drawText(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getArgument(2) as MapFont,
                        it.getString(3)!!
                    )
                }
        }
    }
}
