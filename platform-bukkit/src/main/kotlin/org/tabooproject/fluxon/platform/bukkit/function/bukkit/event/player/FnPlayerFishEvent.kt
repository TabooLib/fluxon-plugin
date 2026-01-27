package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerFishEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires


@Requires(classes = ["org.bukkit.event.player.PlayerFishEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerFishEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerFishEvent::class.java)
                .function("caught", 0) { it.target?.caught }
                .function("hook", 0) { it.target?.hook }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("expToDrop", 0) { it.target?.expToDrop }
                .function("setExpToDrop", 1) { it.target?.setExpToDrop(it.getNumber(0).toInt()) }
                .function("hand", 0) { it.target?.hand }
                .function("state", 0) { it.target?.state }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerFishEvent.getHandlerList() }

                .function("isFishing", 0) { it.target?.let { e -> e.state == PlayerFishEvent.State.FISHING } }
                .function("isCaughtFish", 0) { it.target?.let { e -> e.state == PlayerFishEvent.State.CAUGHT_FISH } }
                .function(
                    "isCaughtEntity",
                    0
                ) { it.target?.let { e -> e.state == PlayerFishEvent.State.CAUGHT_ENTITY } }
                .function("isInGround", 0) { it.target?.let { e -> e.state == PlayerFishEvent.State.IN_GROUND } }
                .function(
                    "isFailedAttempt",
                    0
                ) { it.target?.let { e -> e.state == PlayerFishEvent.State.FAILED_ATTEMPT } }
                .function("isReelIn", 0) { it.target?.let { e -> e.state == PlayerFishEvent.State.REEL_IN } }
                .function("isBite", 0) { it.target?.let { e -> e.state == PlayerFishEvent.State.BITE } }
        }
    }
}
