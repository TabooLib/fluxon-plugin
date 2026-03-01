package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerItemMendEvent
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


@Requires(classes = ["org.bukkit.event.player.PlayerItemMendEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerItemMendEvent {

    val TYPE = Type.fromClass(PlayerItemMendEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerItemMendEvent::class.java)
                .function("item",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.item) }
                .function("slot",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.slot) }
                .function("experienceOrb",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnExperienceOrb.TYPE).noParams()) { it.setReturnRef(it.target?.experienceOrb) }
                .function("repairAmount",returns(Type.I).noParams()) { it.setReturnRef(it.target?.repairAmount) }
                .function("setRepairAmount", returnsVoid().params(Type.I)) { it.target?.setRepairAmount(it.getInt(0).toInt()) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerItemMendEvent.getHandlerList()) }
        }
    }
}
