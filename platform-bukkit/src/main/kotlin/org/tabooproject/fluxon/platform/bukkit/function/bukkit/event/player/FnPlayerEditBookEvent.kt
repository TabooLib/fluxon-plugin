package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerEditBookEvent
import org.bukkit.inventory.meta.BookMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.player.PlayerEditBookEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerEditBookEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerEditBookEvent::class.java)
                .function("previousBookMeta", 0) { it.target?.previousBookMeta }
                .function("newBookMeta", 0) { it.target?.newBookMeta }
                .function("slot", 0) { it.target?.slot }
                .function("setNewBookMeta", 1) { it.target?.setNewBookMeta(it.getArgument(0) as BookMeta) }
                .function("isSigning", 0) { it.target?.isSigning }
                .function("setSigning", 1) { it.target?.setSigning(it.getBoolean(0)) }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerEditBookEvent.getHandlerList() }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
        }
    }
}
