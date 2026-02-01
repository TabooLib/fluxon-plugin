package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.enchantment

import org.bukkit.event.enchantment.PrepareItemEnchantEvent
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

@Requires(classes = ["org.bukkit.event.enchantment.PrepareItemEnchantEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPrepareItemEnchantEvent {

    val TYPE = Type.fromClass(PrepareItemEnchantEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareItemEnchantEvent::class.java)
                .function("enchanter", returnsObject().noParams()) { it.setReturnRef(it.target?.enchanter) }
                .function("enchantBlock", returnsObject().noParams()) { it.setReturnRef(it.target?.enchantBlock) }
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("expLevelCostsOffered", returnsObject().noParams()) { it.setReturnRef(it.target?.expLevelCostsOffered) }
                .function("offers", returnsObject().noParams()) { it.setReturnRef(it.target?.offers) }
                .function("enchantmentBonus", returns(Type.I).noParams()) { it.setReturnInt(it.target?.enchantmentBonus ?: 0) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PrepareItemEnchantEvent.getHandlerList()) }
        }
    }
}
