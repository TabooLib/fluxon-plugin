package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.enchantment

import org.bukkit.event.enchantment.EnchantItemEvent
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

@Requires(classes = ["org.bukkit.event.enchantment.EnchantItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantItemEvent {

    val TYPE = Type.fromClass(EnchantItemEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantItemEvent::class.java)
                .function("enchanter", returnsObject().noParams()) { it.setReturnRef(it.target?.enchanter) }
                .function("enchantBlock", returnsObject().noParams()) { it.setReturnRef(it.target?.enchantBlock) }
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("expLevelCost", returns(Type.I).noParams()) { it.setReturnInt(it.target?.expLevelCost ?: 0) }
                .function("setExpLevelCost", returnsVoid().params(Type.I)) { it.target?.setExpLevelCost(it.getInt(0).toInt()) }
                .function("enchantmentHint", returnsObject().noParams()) { it.setReturnRef(it.target?.enchantmentHint) }
                .function("levelHint", returns(Type.I).noParams()) { it.setReturnInt(it.target?.levelHint ?: 0) }
                .function("whichButton", returns(Type.I).noParams()) { it.setReturnInt(it.target?.whichButton() ?: 0) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EnchantItemEvent.getHandlerList()) }
        }
    }
}
