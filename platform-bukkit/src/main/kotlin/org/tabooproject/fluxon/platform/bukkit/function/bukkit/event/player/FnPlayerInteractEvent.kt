package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPlayerInteractEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerInteractEvent::class.java)
                .function("action", 0) { it.target?.action?.name }
                .function("isBlockInHand", 0) { it.target?.isBlockInHand }
                .function("isLeftClick", 0) { it.target?.let { e -> e.action == Action.LEFT_CLICK_AIR || e.action == Action.LEFT_CLICK_BLOCK } }
                .function("isRightClick", 0) { it.target?.let { e -> e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK } }
                .function("isClickAir", 0) { it.target?.let { e -> e.action == Action.LEFT_CLICK_AIR || e.action == Action.RIGHT_CLICK_AIR } }
                .function("isClickBlock", 0) { it.target?.let { e -> e.action == Action.LEFT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_BLOCK } }
                .function("isPhysical", 0) { it.target?.let { e -> e.action == Action.PHYSICAL } }
                .function("hand", 0) { it.target?.hand }
                .function("item", 0) { it.target?.item }
                .function("clickedBlock", 0) { it.target?.clickedBlock }
                .function("blockFace", 0) { it.target?.blockFace }
                .function("hasBlock", 0) { it.target?.hasBlock() }
                .function("hasItem", 0) { it.target?.hasItem() }
                .function("isBlockPlace", 0) { it.target?.isBlockInHand }
        }
    }
}
