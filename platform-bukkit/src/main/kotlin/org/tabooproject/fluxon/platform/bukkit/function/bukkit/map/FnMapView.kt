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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapView"])
@PlatformSide(Platform.BUKKIT)
object FnMapView {

    val TYPE = Type.fromClass(MapView::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapView::class.java)
                .function("id", returns(Type.I).noParams()) { it.setReturnInt(it.target?.id ?: 0) }
                .function("isVirtual", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isVirtual ?: false) }
                .function("scale",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapViewScale.TYPE).noParams()) { it.setReturnRef(it.target?.scale) }
                .function("setScale",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapViewScale.TYPE)) { it.target?.setScale(it.getRef(0) as MapView.Scale) }
                .function("centerX", returns(Type.I).noParams()) { it.setReturnInt(it.target?.centerX ?: 0) }
                .function("centerZ", returns(Type.I).noParams()) { it.setReturnInt(it.target?.centerZ ?: 0) }
                .function("setCenterX", returnsVoid().params(Type.I)) { it.target?.setCenterX(it.getInt(0).toInt()) }
                .function("setCenterZ", returnsVoid().params(Type.I)) { it.target?.setCenterZ(it.getInt(0).toInt()) }
                .function("world", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE).noParams()) { it.setReturnRef(it.target?.world) }
                .function("setWorld",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) { it.target?.setWorld(it.getRef(0) as World) }
                .function("renderers",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.renderers) }
                .function("addRenderer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapRenderer.TYPE)) { it.target?.addRenderer(it.getRef(0) as MapRenderer) }
                .function("removeRenderer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapRenderer.TYPE)) { it.target?.removeRenderer(it.getRef(0) as MapRenderer) }
                .function("isTrackingPosition", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTrackingPosition ?: false) }
                .function("setTrackingPosition", returnsVoid().params(Type.Z)) { it.target?.setTrackingPosition(it.getBool(0)) }
                .function("isUnlimitedTracking", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isUnlimitedTracking ?: false) }
                .function("setUnlimitedTracking", returnsVoid().params(Type.Z)) { it.target?.setUnlimitedTracking(it.getBool(0)) }
                .function("isLocked", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLocked ?: false) }
                .function("setLocked", returnsVoid().params(Type.Z)) { it.target?.setLocked(it.getBool(0)) }
        }
    }
}

@Requires(classes = ["org.bukkit.map.MapView\$Scale"])
@PlatformSide(Platform.BUKKIT)
object FnMapViewScale : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.map.MapView.Scale>() {

    override val enumClass: Class<org.bukkit.map.MapView.Scale> = org.bukkit.map.MapView.Scale::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapView.Scale::class.java)
                // static
                .function("valueOf", returns(TYPE).params(Type.I)) { it.setReturnRef(MapView.Scale.valueOf(it.getInt(0).toByte())) }
                .function("value", returns(Type.I).noParams()) { it.setReturnInt(it.target?.value?.toInt() ?: 0) }
        }
    }
}
