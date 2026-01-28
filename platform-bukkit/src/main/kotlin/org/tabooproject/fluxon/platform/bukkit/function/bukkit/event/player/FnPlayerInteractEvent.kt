package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.Event
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.player.PlayerInteractEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerInteractEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerInteractEvent::class.java)
                .function("action", returnsObject().noParams()) { it.target?.action }

                .function("isLeftClick", returns(Type.Z).noParams()) { it.target?.let { e -> e.action == Action.LEFT_CLICK_AIR || e.action == Action.LEFT_CLICK_BLOCK } }
                .function("isRightClick", returns(Type.Z).noParams()) { it.target?.let { e -> e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK } }
                .function("isClickAir", returns(Type.Z).noParams()) { it.target?.let { e -> e.action == Action.LEFT_CLICK_AIR || e.action == Action.RIGHT_CLICK_AIR } }
                .function("isClickBlock", returns(Type.Z).noParams()) { it.target?.let { e -> e.action == Action.LEFT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_BLOCK } }
                .function("isPhysical", returns(Type.Z).noParams()) { it.target?.let { e -> e.action == Action.PHYSICAL } }
                .function("isBlockPlace", returns(Type.Z).noParams()) { it.target?.isBlockInHand }

                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("item", returnsObject().noParams()) { it.target?.getItem() }
                .function("material", returnsObject().noParams()) { it.target?.material }
                .function("hasBlock", returns(Type.Z).noParams()) { it.target?.hasBlock() }
                .function("hasItem", returns(Type.Z).noParams()) { it.target?.hasItem() }
                .function("isBlockInHand", returns(Type.Z).noParams()) { it.target?.isBlockInHand }
                .function("clickedBlock", returnsObject().noParams()) { it.target?.clickedBlock }
                .function("blockFace", returnsObject().noParams()) { it.target?.getBlockFace() }
                .function("setUseInteractedBlock", returnsObject().params(Type.OBJECT)) { it.target?.setUseInteractedBlock(it.getRef(0) as Event.Result) }
                .function("setUseItemInHand", returnsObject().params(Type.OBJECT)) { it.target?.setUseItemInHand(it.getRef(0) as Event.Result) }
                .function("hand", returnsObject().noParams()) { it.target?.hand }
                .function("clickedPosition", returnsObject().noParams()) { it.target?.clickedPosition }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerInteractEvent.getHandlerList() }
        }
    }
}
