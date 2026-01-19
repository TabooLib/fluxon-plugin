package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.entity.Player
import org.bukkit.map.MapCanvas
import org.bukkit.map.MapRenderer
import org.bukkit.map.MapView
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMapRenderer {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapRenderer::class.java)
                .function("isContextual", 0) { it.target?.isContextual }
                .function("initialize", 1) { it.target?.initialize(it.getArgument(0) as MapView) }
                .function("render", 3) {
                    it.target?.render(
                        it.getArgument(0) as MapView,
                        it.getArgument(1) as MapCanvas,
                        it.getArgument(2) as Player
                    )
                }
        }
    }
}
