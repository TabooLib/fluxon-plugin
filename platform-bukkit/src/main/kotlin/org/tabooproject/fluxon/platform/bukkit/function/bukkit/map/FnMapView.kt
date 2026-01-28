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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapView"])
@PlatformSide(Platform.BUKKIT)
object FnMapView {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapView::class.java)
                .function("id", returnsObject().noParams()) { it.setReturnRef(it.target?.id) }
                .function("isVirtual", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isVirtual) }
                .function("scale", returnsObject().noParams()) { it.setReturnRef(it.target?.scale) }
                .function("setScale", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setScale(it.getRef(0) as MapView.Scale)) }
                .function("centerX", returnsObject().noParams()) { it.setReturnRef(it.target?.centerX) }
                .function("centerZ", returnsObject().noParams()) { it.setReturnRef(it.target?.centerZ) }
                .function("setCenterX", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCenterX(it.getInt(0).toInt())) }
                .function("setCenterZ", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCenterZ(it.getInt(0).toInt())) }
                .function("world", returnsObject().noParams()) { it.setReturnRef(it.target?.world) }
                .function("setWorld", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setWorld(it.getRef(0) as World)) }
                .function("renderers", returnsObject().noParams()) { it.setReturnRef(it.target?.renderers) }
                .function("addRenderer", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addRenderer(it.getRef(0) as MapRenderer)) }
                .function("removeRenderer", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeRenderer(it.getRef(0) as MapRenderer)) }
                .function("isTrackingPosition", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isTrackingPosition) }
                .function("setTrackingPosition", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTrackingPosition(it.getBool(0))) }
                .function("isUnlimitedTracking", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isUnlimitedTracking) }
                .function("setUnlimitedTracking", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setUnlimitedTracking(it.getBool(0))) }
                .function("isLocked", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isLocked) }
                .function("setLocked", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLocked(it.getBool(0))) }
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
                .function("valueOf", returnsObject().params(Type.OBJECT)) { it.setReturnRef(MapView.Scale.valueOf(it.getInt(0).toByte())) }
                .function("value", returnsObject().noParams()) { it.setReturnRef(it.target?.value) }
        }
    }
}
