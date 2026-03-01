package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.VillagerReplenishTradeEvent
import org.bukkit.inventory.MerchantRecipe
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

@Requires(classes = ["org.bukkit.event.entity.VillagerReplenishTradeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnVillagerReplenishTradeEvent {

    val TYPE = Type.fromClass(VillagerReplenishTradeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VillagerReplenishTradeEvent::class.java)
                .function("recipe",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnMerchantRecipe.TYPE).noParams()) { it.setReturnRef(it.target?.recipe) }
                .function("setRecipe",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnMerchantRecipe.TYPE)) { it.target?.setRecipe(it.getRef(0) as MerchantRecipe) }
                .function("bonus", returns(Type.I).noParams()) { it.setReturnInt(it.target?.bonus ?: 0) }
                .function("setBonus", returnsVoid().params(Type.I)) { it.target?.setBonus(it.getInt(0).toInt()) }
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(VillagerReplenishTradeEvent.getHandlerList()) }
        }
    }
}
