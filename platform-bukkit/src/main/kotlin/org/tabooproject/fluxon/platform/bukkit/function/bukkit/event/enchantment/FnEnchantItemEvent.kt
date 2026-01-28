package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.enchantment

import org.bukkit.event.enchantment.EnchantItemEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.enchantment.EnchantItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantItemEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantItemEvent::class.java)
                .function("enchanter", returnsObject().noParams()) { it.target?.enchanter }
                .function("enchantBlock", returnsObject().noParams()) { it.target?.enchantBlock }
                .function("item", returnsObject().noParams()) { it.target?.item }
                .function("expLevelCost", returnsObject().noParams()) { it.target?.expLevelCost }
                .function("setExpLevelCost", returnsObject().params(Type.OBJECT)) { it.target?.setExpLevelCost(it.getInt(0).toInt()) }
                .function("enchantmentHint", returnsObject().noParams()) { it.target?.enchantmentHint }
                .function("levelHint", returnsObject().noParams()) { it.target?.levelHint }
                .function("whichButton", returnsObject().noParams()) { it.target?.whichButton() }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { EnchantItemEvent.getHandlerList() }
        }
    }
}
