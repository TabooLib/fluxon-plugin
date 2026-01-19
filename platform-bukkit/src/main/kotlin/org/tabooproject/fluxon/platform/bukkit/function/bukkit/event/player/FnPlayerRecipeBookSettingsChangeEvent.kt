package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerRecipeBookSettingsChangeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerRecipeBookSettingsChangeEvent::class.java)
                .function("recipeBookType", 0) { it.target?.recipeBookType }
                .function("isOpen", 0) { it.target?.isOpen }
                .function("isFiltering", 0) { it.target?.isFiltering }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerRecipeBookSettingsChangeEvent.getHandlerList() }
        }
    }
}
