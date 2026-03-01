package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerFishEvent
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


@Requires(classes = ["org.bukkit.event.player.PlayerFishEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerFishEvent {

    val TYPE = Type.fromClass(PlayerFishEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerFishEvent::class.java)
                .function("caught",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.caught) }
                .function("hook",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnFishHook.TYPE).noParams()) { it.setReturnRef(it.target?.hook) }
                .function("expToDrop", returns(Type.I).noParams()) { it.setReturnInt(it.target?.expToDrop ?: 0) }
                .function("setExpToDrop", returnsVoid().params(Type.I)) { it.target?.setExpToDrop(it.getInt(0)) }
                .function("hand",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.hand) }
                .function("state", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerFishEventState.TYPE).noParams()) { it.setReturnRef(it.target?.state) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerFishEvent.getHandlerList()) }

                .function("isFishing", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.let { e -> e.state == PlayerFishEvent.State.FISHING } ?: false) }
                .function("isCaughtFish", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.let { e -> e.state == PlayerFishEvent.State.CAUGHT_FISH } ?: false) }
                .function("isCaughtEntity", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.let { e -> e.state == PlayerFishEvent.State.CAUGHT_ENTITY } ?: false) }
                .function("isInGround", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.let { e -> e.state == PlayerFishEvent.State.IN_GROUND } ?: false) }
                .function("isFailedAttempt", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.let { e -> e.state == PlayerFishEvent.State.FAILED_ATTEMPT } ?: false) }
                .function("isReelIn", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.let { e -> e.state == PlayerFishEvent.State.REEL_IN } ?: false) }
                .function("isBite", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.let { e -> e.state == PlayerFishEvent.State.BITE } ?: false) }
        }
    }
}
