package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.VillagerAcquireTradeEvent
import org.bukkit.inventory.MerchantRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.VillagerAcquireTradeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnVillagerAcquireTradeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VillagerAcquireTradeEvent::class.java)
                .function("recipe", returnsObject().noParams()) { it.target?.recipe }
                .function("setRecipe", returnsObject().params(Type.OBJECT)) { it.target?.setRecipe(it.getRef(0) as MerchantRecipe) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("entity", returnsObject().noParams()) { it.target?.getEntity() }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { VillagerAcquireTradeEvent.getHandlerList() }
        }
    }
}
