package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.enchantment

import org.bukkit.event.enchantment.PrepareItemEnchantEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.enchantment.PrepareItemEnchantEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPrepareItemEnchantEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareItemEnchantEvent::class.java)
                .function("enchanter", returnsObject().noParams()) { it.target?.enchanter }
                .function("enchantBlock", returnsObject().noParams()) { it.target?.enchantBlock }
                .function("item", returnsObject().noParams()) { it.target?.item }
                .function("expLevelCostsOffered", returnsObject().noParams()) { it.target?.expLevelCostsOffered }
                .function("offers", returnsObject().noParams()) { it.target?.offers }
                .function("enchantmentBonus", returnsObject().noParams()) { it.target?.enchantmentBonus }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PrepareItemEnchantEvent.getHandlerList() }
        }
    }
}
