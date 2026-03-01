package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapPalette
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.awt.Image
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapPalette"])
@PlatformSide(Platform.BUKKIT)
object FnMapPalette {

    val TYPE = Type.fromClass(MapPalette::class.java)
    private val IMAGE = Type.fromClass(Image::class.java)
    private val BYTE_ARRAY = Type.fromClass(ByteArray::class.java)
    private val AWT_COLOR = Type.fromClass(java.awt.Color::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapPalette::class.java)
                // static
                .function("resizeImage", returns(IMAGE).params(IMAGE)) { it.setReturnRef(MapPalette.resizeImage(it.getRef(0) as Image)) }
                // static
                .function("imageToBytes", returns(BYTE_ARRAY).params(IMAGE)) { it.setReturnRef(MapPalette.imageToBytes(it.getRef(0) as Image)) }
                // static
                .function("matchColor", returns(Type.I).params(AWT_COLOR)) {
                    it.setReturnInt(MapPalette.matchColor(it.getRef(0) as java.awt.Color).toInt())
                }
                .function("matchColor", returns(Type.I).params(Type.I, Type.I, Type.I)) {
                    it.setReturnInt(MapPalette.matchColor(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt()
                    ).toInt())
                }
                // static
                .function("getColor", returns(AWT_COLOR).params(Type.I)) { it.setReturnRef(MapPalette.getColor(it.getInt(0).toByte())) }
                // static
                .function("setMapColorCache",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapPaletteMapColorCache.TYPE)) {
                    MapPalette.setMapColorCache(it.getRef(0) as MapPalette.MapColorCache)
                }
        }
    }
}

@Requires(classes = ["org.bukkit.map.MapPalette\$MapColorCache"])
@PlatformSide(Platform.BUKKIT)
object FnMapPaletteMapColorCache {

    val TYPE = Type.fromClass(MapPalette.MapColorCache::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapPalette.MapColorCache::class.java)
                .function("isCached", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCached ?: false) }
        }
    }
}
