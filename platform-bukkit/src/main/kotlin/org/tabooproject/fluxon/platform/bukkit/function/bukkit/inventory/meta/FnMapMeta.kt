package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Color
import org.bukkit.inventory.meta.MapMeta
import org.bukkit.map.MapView
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.MapMeta"])
@PlatformSide(Platform.BUKKIT)
object FnMapMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapMeta::class.java)
                .function("hasMapId", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasMapId()) }
                .function("mapId", returnsObject().noParams()) { it.setReturnRef(it.target?.mapId) }
                .function("setMapId", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMapId(it.getInt(0).toInt())) }
                .function("hasMapView", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasMapView()) }
                .function("mapView", returnsObject().noParams()) { it.setReturnRef(it.target?.mapView) }
                .function("setMapView", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMapView(it.getRef(0) as MapView)) }
                .function("isScaling", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isScaling) }
                .function("setScaling", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setScaling(it.getBool(0))) }
                .function("hasLocationName", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasLocationName()) }
                .function("locationName", returnsObject().noParams()) { it.setReturnRef(it.target?.locationName) }
                .function("setLocationName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLocationName(it.getString(0))) }
                .function("hasColor", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasColor()) }
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setColor(it.getRef(0) as Color)) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
