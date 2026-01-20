package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.Event
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnPlayerInteractEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerInteractEvent::class.java)
                .function("action", 0) { it.target?.action }

                .function(
                    "isLeftClick",
                    0
                ) { it.target?.let { e -> e.action == Action.LEFT_CLICK_AIR || e.action == Action.LEFT_CLICK_BLOCK } }
                .function(
                    "isRightClick",
                    0
                ) { it.target?.let { e -> e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK } }
                .function(
                    "isClickAir",
                    0
                ) { it.target?.let { e -> e.action == Action.LEFT_CLICK_AIR || e.action == Action.RIGHT_CLICK_AIR } }
                .function(
                    "isClickBlock",
                    0
                ) { it.target?.let { e -> e.action == Action.LEFT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_BLOCK } }
                .function("isPhysical", 0) { it.target?.let { e -> e.action == Action.PHYSICAL } }
                .function("isBlockPlace", 0) { it.target?.isBlockInHand }

                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("item", 0) { it.target?.getItem() }
                .function("material", 0) { it.target?.material }
                .function("hasBlock", 0) { it.target?.hasBlock() }
                .function("hasItem", 0) { it.target?.hasItem() }
                .function("isBlockInHand", 0) { it.target?.isBlockInHand }
                .function("clickedBlock", 0) { it.target?.clickedBlock }
                .function("blockFace", 0) { it.target?.getBlockFace() }
                .function(
                    "setUseInteractedBlock",
                    1
                ) { it.target?.setUseInteractedBlock(it.getArgument(0) as Event.Result) }
                .function("setUseItemInHand", 1) { it.target?.setUseItemInHand(it.getArgument(0) as Event.Result) }
                .function("hand", 0) { it.target?.hand }
                .function("clickedPosition", 0) { it.target?.clickedPosition }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { PlayerInteractEvent.getHandlerList() }
        }
    }
}
