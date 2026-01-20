package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerArmorStandManipulateEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerArmorStandManipulateEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerArmorStandManipulateEvent::class.java)
                .function("playerItem", 0) { it.target?.playerItem }
                .function("armorStandItem", 0) { it.target?.armorStandItem }
                .function("slot", 0) { it.target?.slot }
                .function("hand", 0) { it.target?.hand }
                .function("rightClicked", 0) { it.target?.rightClicked }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerArmorStandManipulateEvent.getHandlerList() }
        }
    }
}
