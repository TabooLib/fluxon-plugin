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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.MapMeta"])
@PlatformSide(Platform.BUKKIT)
object FnMapMeta {

    val TYPE = Type.fromClass(MapMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapMeta::class.java)
                .function("hasMapId", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasMapId() ?: false) }
                .function("mapId", returns(Type.I).noParams()) { it.setReturnInt(it.target?.mapId ?: 0) }
                .function("setMapId", returnsVoid().params(Type.I)) { it.target?.setMapId(it.getInt(0).toInt()) }
                .function("hasMapView", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasMapView() ?: false) }
                .function("mapView", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapView.TYPE).noParams()) { it.setReturnRef(it.target?.mapView) }
                .function("setMapView",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapView.TYPE)) { it.target?.setMapView(it.getRef(0) as MapView) }
                .function("isScaling", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isScaling ?: false) }
                .function("setScaling", returnsVoid().params(Type.Z)) { it.target?.setScaling(it.getBool(0)) }
                .function("hasLocationName", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasLocationName() ?: false) }
                .function("locationName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.locationName) }
                .function("setLocationName", returnsVoid().params(Type.STRING)) { it.target?.setLocationName(it.getString(0)) }
                .function("hasColor", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasColor() ?: false) }
                .function("color", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE)) { it.target?.setColor(it.getRef(0) as Color) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnMapMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
