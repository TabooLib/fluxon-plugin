package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnInventory {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Inventory::class.java)
                .function("size", 0) { it.target?.size }
                .function("maxStackSize", 0) { it.target?.maxStackSize }
                .function("setMaxStackSize", 1) { it.target?.setMaxStackSize(it.getNumber(0).toInt()) }
                .function("item", 1) { it.target?.getItem(it.getNumber(0).toInt()) }
                .function("setItem", 2) { it.target?.setItem(it.getNumber(0).toInt(), it.getArgument(1) as ItemStack) }
                .function("contents", 0) { it.target?.contents }
                .function("setContents", 1) { it.target?.setContents(it.getArgument(0) as Array<ItemStack>) }
                .function("storageContents", 0) { it.target?.storageContents }
                .function(
                    "setStorageContents",
                    1
                ) { it.target?.setStorageContents(it.getArgument(0) as Array<ItemStack>) }
                .function("contains", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Material -> it.target?.contains(var1)
                        is ItemStack -> it.target?.contains(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    }
                }
                .function("contains", 2) {
                    when (val var1 = it.getArgument(0)) {
                        is Material -> it.target?.contains(var1, it.getNumber(1).toInt())
                        is ItemStack -> it.target?.contains(var1, it.getNumber(1).toInt())
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    }
                }
                .function("containsAtLeast", 2) {
                    it.target?.containsAtLeast(
                        it.getArgument(0) as ItemStack,
                        it.getNumber(1).toInt()
                    )
                }
                .function("first", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Material -> it.target?.first(var1)
                        is ItemStack -> it.target?.first(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    }
                }
                .function("firstEmpty", 0) { it.target?.firstEmpty() }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("remove", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Material -> it.target?.remove(var1)
                        is ItemStack -> it.target?.remove(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    }
                }
                .function("clear", 1) { it.target?.clear(it.getNumber(0).toInt()) }
                .function("clear", 0) { it.target?.clear() }
                .function("viewers", 0) { it.target?.viewers }
                .function("type", 0) { it.target?.type }
                .function("holder", 0) { it.target?.holder }
                .function("iterator", 0) { it.target?.iterator() }
                .function("iterator", 1) { it.target?.iterator(it.getNumber(0).toInt()) }
                .function("location", 0) { it.target?.location }
        }
    }
}
