package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.enchantment

import org.bukkit.event.enchantment.EnchantItemEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.enchantment.EnchantItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantItemEvent {

    val TYPE = Type.fromClass(EnchantItemEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantItemEvent::class.java)
                .function("enchanter", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.enchanter) }
                .function("enchantBlock", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.enchantBlock) }
                .function("item", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.item) }
                .function("expLevelCost", returns(Type.I).noParams()) { it.setReturnInt(it.target?.expLevelCost ?: 0) }
                .function("setExpLevelCost", returnsVoid().params(Type.I)) { it.target?.setExpLevelCost(it.getInt(0)) }
                .function("enchantmentHint", returns(FnEnchantment.TYPE).noParams()) { it.setReturnRef(it.target?.enchantmentHint) }
                .function("levelHint", returns(Type.I).noParams()) { it.setReturnInt(it.target?.levelHint ?: 0) }
                .function("whichButton", returns(Type.I).noParams()) { it.setReturnInt(it.target?.whichButton() ?: 0) }
        }
    }
}
