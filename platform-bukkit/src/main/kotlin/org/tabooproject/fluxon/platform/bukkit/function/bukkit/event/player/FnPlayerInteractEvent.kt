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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.event.player.PlayerInteractEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerInteractEvent {

    val TYPE = Type.fromClass(PlayerInteractEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerInteractEvent::class.java)
                .function("action", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block.FnAction.TYPE).noParams()) { it.setReturnRef(it.target?.action) }

                .function("isLeftClick", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.let { e -> e.action == Action.LEFT_CLICK_AIR || e.action == Action.LEFT_CLICK_BLOCK } ?: false)
                }
                .function("isRightClick", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.let { e -> e.action == Action.RIGHT_CLICK_AIR || e.action == Action.RIGHT_CLICK_BLOCK } ?: false)
                }
                .function("isClickAir", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.let { e -> e.action == Action.LEFT_CLICK_AIR || e.action == Action.RIGHT_CLICK_AIR } ?: false)
                }
                .function("isClickBlock", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.let { e -> e.action == Action.LEFT_CLICK_BLOCK || e.action == Action.RIGHT_CLICK_BLOCK } ?: false)
                }
                .function("isPhysical", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.let { e -> e.action == Action.PHYSICAL } ?: false) }
                .function("isBlockPlace", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.action == Action.RIGHT_CLICK_BLOCK)
                }

                .function("item",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.getItem()) }
                .function("material",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.material) }
                .function("hasBlock", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasBlock() ?: false) }
                .function("hasItem", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasItem() ?: false) }
                .function("isBlockInHand", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBlockInHand ?: false) }
                .function("clickedBlock",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.clickedBlock) }
                .function("blockFace",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.getBlockFace()) }
                .function("setUseInteractedBlock",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEventResult.TYPE)) { it.target?.setUseInteractedBlock(it.getRef(0) as Event.Result) }
                .function("setUseItemInHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEventResult.TYPE)) { it.target?.setUseItemInHand(it.getRef(0) as Event.Result) }
                .function("hand",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.hand) }
                .function("clickedPosition",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.clickedPosition) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerInteractEvent.getHandlerList()) }
        }
    }
}
