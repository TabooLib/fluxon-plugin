package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnItemStack {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemStack::class.java)
                .function("type", 0) { it.target?.type }
                .syncFunction("setType", 1) { it.target?.apply { type = it.getArgument(0) as Material } }
//                .function("name", 0) { it.target?.itemMeta?.displayName ?: it.target?.getI18nName() } // TODO: setter
                .function("amount", 0) { it.target?.amount }
                .syncFunction("setAmount", 1) { it.target?.apply { amount = it.getNumber(0).toInt() } }
                .function("maxAmount", 0) { it.target?.maxStackSize }
                .function("durability", 0) { it.target?.durability } // TODO: setter
                .function("enchantments", 0) { it.target?.enchantments }
                .function("itemMeta", 0) { it.target?.itemMeta }
                .syncFunction("setItemMeta", 1) { it.target?.apply { itemMeta = it.getArgument(0) as ItemMeta } }
                .function("hasMeta", 0) { it.target?.hasItemMeta() }
                .function("clone", 0) { it.target?.clone() }
                .function("data", 0) { it.target?.data }
                .function("serialize", 0) { it.target?.serialize() }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}