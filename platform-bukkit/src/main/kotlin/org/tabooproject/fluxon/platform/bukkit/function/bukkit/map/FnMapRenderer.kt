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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapRenderer"])
@PlatformSide(Platform.BUKKIT)
object FnMapRenderer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapRenderer::class.java)
                .function("isContextual", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isContextual) }
                .function("initialize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.initialize(it.getRef(0) as MapView)) }
                .function("render", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.render(
                        it.getRef(0) as MapView,
                        it.getRef(1) as MapCanvas,
                        it.getRef(2) as Player
                    ))
                }
        }
    }
}
