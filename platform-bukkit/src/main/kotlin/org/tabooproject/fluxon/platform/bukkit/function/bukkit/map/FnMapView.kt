package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.World
import org.bukkit.map.MapRenderer
import org.bukkit.map.MapView
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.map.MapView"])
@PlatformSide(Platform.BUKKIT)
object FnMapView {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapView::class.java)
                .function("id", 0) { it.target?.id }
                .function("isVirtual", 0) { it.target?.isVirtual }
                .function("scale", 0) { it.target?.scale }
                .function("setScale", 1) { it.target?.setScale(it.getArgument(0) as MapView.Scale) }
                .function("centerX", 0) { it.target?.centerX }
                .function("centerZ", 0) { it.target?.centerZ }
                .function("setCenterX", 1) { it.target?.setCenterX(it.getNumber(0).toInt()) }
                .function("setCenterZ", 1) { it.target?.setCenterZ(it.getNumber(0).toInt()) }
                .function("world", 0) { it.target?.world }
                .function("setWorld", 1) { it.target?.setWorld(it.getArgument(0) as World) }
                .function("renderers", 0) { it.target?.renderers }
                .function("addRenderer", 1) { it.target?.addRenderer(it.getArgument(0) as MapRenderer) }
                .function("removeRenderer", 1) { it.target?.removeRenderer(it.getArgument(0) as MapRenderer) }
                .function("isTrackingPosition", 0) { it.target?.isTrackingPosition }
                .function("setTrackingPosition", 1) { it.target?.setTrackingPosition(it.getBoolean(0)) }
                .function("isUnlimitedTracking", 0) { it.target?.isUnlimitedTracking }
                .function("setUnlimitedTracking", 1) { it.target?.setUnlimitedTracking(it.getBoolean(0)) }
                .function("isLocked", 0) { it.target?.isLocked }
                .function("setLocked", 1) { it.target?.setLocked(it.getBoolean(0)) }
        }
    }
}

@Requires(classes = ["org.bukkit.map.MapView.Scale"])
@PlatformSide(Platform.BUKKIT)
object FnMapViewScale {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapView.Scale::class.java)
                // static
                .function("valueOf", 1) { MapView.Scale.valueOf(it.getNumber(0).toByte()) }
                .function("value", 0) { it.target?.value }
        }
    }
}
