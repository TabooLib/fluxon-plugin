package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerFishEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.player.PlayerFishEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerFishEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerFishEvent::class.java)
                .function("caught", returnsObject().noParams()) { it.target?.caught }
                .function("hook", returnsObject().noParams()) { it.target?.hook }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("expToDrop", returnsObject().noParams()) { it.target?.expToDrop }
                .function("setExpToDrop", returnsObject().params(Type.OBJECT)) { it.target?.setExpToDrop(it.getInt(0).toInt()) }
                .function("hand", returnsObject().noParams()) { it.target?.hand }
                .function("state", returnsObject().noParams()) { it.target?.state }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerFishEvent.getHandlerList() }

                .function("isFishing", returns(Type.Z).noParams()) { it.target?.let { e -> e.state == PlayerFishEvent.State.FISHING } }
                .function("isCaughtFish", returns(Type.Z).noParams()) { it.target?.let { e -> e.state == PlayerFishEvent.State.CAUGHT_FISH } }
                .function("isCaughtEntity", returns(Type.Z).noParams()) { it.target?.let { e -> e.state == PlayerFishEvent.State.CAUGHT_ENTITY } }
                .function("isInGround", returns(Type.Z).noParams()) { it.target?.let { e -> e.state == PlayerFishEvent.State.IN_GROUND } }
                .function("isFailedAttempt", returns(Type.Z).noParams()) { it.target?.let { e -> e.state == PlayerFishEvent.State.FAILED_ATTEMPT } }
                .function("isReelIn", returns(Type.Z).noParams()) { it.target?.let { e -> e.state == PlayerFishEvent.State.REEL_IN } }
                .function("isBite", returns(Type.Z).noParams()) { it.target?.let { e -> e.state == PlayerFishEvent.State.BITE } }
        }
    }
}
