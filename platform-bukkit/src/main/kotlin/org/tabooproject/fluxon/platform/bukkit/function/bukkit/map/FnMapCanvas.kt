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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.map.MapCanvas"])
@PlatformSide(Platform.BUKKIT)
object FnMapCanvas {

    val TYPE = Type.fromClass(MapCanvas::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCanvas::class.java)
                .function("mapView", returnsObject().noParams()) { it.setReturnRef(it.target?.mapView) }
                .function("cursors", returnsObject().noParams()) { it.setReturnRef(it.target?.cursors) }
                .function("setCursors", returnsVoid().params(Type.OBJECT)) { it.target?.setCursors(it.getRef(0) as MapCursorCollection) }
                .function("setPixelColor", returnsVoid().params(Type.I, Type.I, Type.OBJECT)) {
                    it.target?.setPixelColor(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        (it.getRef(2) as Color).let { color -> java.awt.Color(color.red, color.green, color.blue) }
                    )
                }
                .function("getPixelColor", returnsObject().params(Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getPixelColor(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("getBasePixelColor", returnsObject().params(Type.I, Type.I)) {
                    it.setReturnRef(it.target?.getBasePixelColor(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
                .function("setPixel", returnsVoid().params(Type.I, Type.I, Type.I)) {
                    it.target?.setPixel(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toByte()
                    )
                }
                .function("getPixel", returns(Type.I).params(Type.I, Type.I)) {
                    it.setReturnInt(it.target?.getPixel(it.getInt(0).toInt(), it.getInt(1).toInt())?.toInt() ?: 0)
                }
                .function("getBasePixel", returns(Type.I).params(Type.I, Type.I)) {
                    it.setReturnInt(it.target?.getBasePixel(it.getInt(0).toInt(), it.getInt(1).toInt())?.toInt() ?: 0)
                }
                .function("drawImage", returnsVoid().params(Type.I, Type.I, Type.OBJECT)) {
                    it.target?.drawImage(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as Image
                    )
                }
                .function("drawText", returnsVoid().params(Type.I, Type.I, Type.OBJECT, Type.STRING)) {
                    it.target?.drawText(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getRef(2) as MapFont,
                        it.getString(3)!!
                    )
                }
        }
    }
}
