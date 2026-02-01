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
                .function("recipe", returnsObject().noParams()) { it.setReturnRef(it.target?.recipe) }
                .function("setRecipe", returnsVoid().params(Type.OBJECT)) { it.target?.setRecipe(it.getRef(0) as MerchantRecipe) }
                .function("bonus", returns(Type.I).noParams()) { it.setReturnInt(it.target?.bonus ?: 0) }
                .function("setBonus", returnsVoid().params(Type.I)) { it.target?.setBonus(it.getInt(0).toInt()) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(VillagerReplenishTradeEvent.getHandlerList()) }
        }
    }
}
