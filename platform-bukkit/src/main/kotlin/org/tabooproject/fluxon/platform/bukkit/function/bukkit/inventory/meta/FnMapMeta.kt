package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Color
import org.bukkit.inventory.meta.MapMeta
import org.bukkit.map.MapView
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMapMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapMeta::class.java)
                .function("hasMapId", 0) { it.target?.hasMapId() }
                .function("mapId", 0) { it.target?.mapId }
                .function("setMapId", 1) { it.target?.setMapId(it.getNumber(0).toInt()) }
                .function("hasMapView", 0) { it.target?.hasMapView() }
                .function("mapView", 0) { it.target?.mapView }
                .function("setMapView", 1) { it.target?.setMapView(it.getArgument(0) as MapView) }
                .function("isScaling", 0) { it.target?.isScaling }
                .function("setScaling", 1) { it.target?.setScaling(it.getBoolean(0)) }
                .function("hasLocationName", 0) { it.target?.hasLocationName() }
                .function("locationName", 0) { it.target?.locationName }
                .function("setLocationName", 1) { it.target?.setLocationName(it.getString(0)) }
                .function("hasColor", 0) { it.target?.hasColor() }
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as Color) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
