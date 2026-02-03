package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.enchantment

import org.bukkit.enchantments.EnchantmentOffer
import org.bukkit.event.enchantment.PrepareItemEnchantEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.enchantment.PrepareItemEnchantEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPrepareItemEnchantEvent {

    val TYPE = Type.fromClass(PrepareItemEnchantEvent::class.java)

    val offerArray = Type(EnchantmentOffer::class.java, 1)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareItemEnchantEvent::class.java)
                .function("enchanter", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.enchanter) }
                .function("enchantBlock", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.enchantBlock) }
                .function("item", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.item) }
                .function("expLevelCostsOffered", returns(StandardTypes.I_ARRAY).noParams()) { it.setReturnRef(it.target?.expLevelCostsOffered) }
                .function("offers", returns(offerArray).noParams()) { it.setReturnRef(it.target?.offers) }
                .function("enchantmentBonus", returns(Type.I).noParams()) { it.setReturnInt(it.target?.enchantmentBonus ?: 0) }
        }
    }
}
