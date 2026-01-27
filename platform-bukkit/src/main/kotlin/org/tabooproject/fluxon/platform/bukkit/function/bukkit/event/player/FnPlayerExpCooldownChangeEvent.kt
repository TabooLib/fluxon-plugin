package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerExpCooldownChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.player.PlayerExpCooldownChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerExpCooldownChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerExpCooldownChangeEvent::class.java)
                .function("reason", 0) { it.target?.reason }
                .function("newCooldown", 0) { it.target?.newCooldown }
                .function("setNewCooldown", 1) { it.target?.setNewCooldown(it.getNumber(0).toInt()) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerExpCooldownChangeEvent.getHandlerList() }
        }
    }
}
