package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.entity.Player
import org.bukkit.map.MapCanvas
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

@Requires(classes = ["org.bukkit.map.MapRenderer"])
@PlatformSide(Platform.BUKKIT)
object FnMapRenderer {

    val TYPE = Type.fromClass(MapRenderer::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapRenderer::class.java)
                .function("isContextual", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isContextual ?: false) }
                .function("initialize",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapView.TYPE)) { it.target?.initialize(it.getRef(0) as MapView) }
                .function("render",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapView.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCanvas.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) {
                    it.target?.render(
                        it.getRef(0) as MapView,
                        it.getRef(1) as MapCanvas,
                        it.getRef(2) as Player
                    )
                }
        }
    }
}
