package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerRecipeBookClickEvent
import org.bukkit.inventory.Recipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerRecipeBookClickEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerRecipeBookClickEvent::class.java)
                .function("originalRecipe", 0) { it.target?.originalRecipe }
                .function("recipe", 0) { it.target?.recipe }
                .function("setRecipe", 1) { it.target?.setRecipe(it.getArgument(0) as Recipe) }
                .function("isShiftClick", 0) { it.target?.isShiftClick }
                .function("setShiftClick", 1) { it.target?.setShiftClick(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerRecipeBookClickEvent.getHandlerList() }
        }
    }
}
