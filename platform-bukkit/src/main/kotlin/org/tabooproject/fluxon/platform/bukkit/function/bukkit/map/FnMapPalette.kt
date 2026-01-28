package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapPalette
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.awt.Image
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapPalette"])
@PlatformSide(Platform.BUKKIT)
object FnMapPalette {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapPalette::class.java)
                // static
                .function("resizeImage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(MapPalette.resizeImage(it.getRef(0) as Image)) }
                // static
                .function("imageToBytes", returnsObject().params(Type.OBJECT)) { it.setReturnRef(MapPalette.imageToBytes(it.getRef(0) as Image)) }
                // static
                .function("matchColor", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        MapPalette.matchColor(it.getRef(0) as java.awt.Color)
                    } else {
                        MapPalette.matchColor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                .function("matchColor", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        MapPalette.matchColor(it.getRef(0) as java.awt.Color)
                    } else {
                        MapPalette.matchColor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toInt()
                        )
                    })
                }
                // static
                .function("getColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(MapPalette.getColor(it.getInt(0).toByte())) }
                // static
                .function("setMapColorCache", returnsObject().params(Type.OBJECT)) { it.setReturnRef(MapPalette.setMapColorCache(it.getRef(0) as MapPalette.MapColorCache)) }
        }
    }
}

@Requires(classes = ["org.bukkit.map.MapPalette.MapColorCache"])
@PlatformSide(Platform.BUKKIT)
object FnMapPaletteMapColorCache {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapPalette.MapColorCache::class.java)
                .function("isCached", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCached) }
        }
    }
}
