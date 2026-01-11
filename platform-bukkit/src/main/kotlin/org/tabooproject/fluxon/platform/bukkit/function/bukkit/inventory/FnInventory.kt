package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

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
                    // boolean contains(@NotNull Material var1)
                    // boolean contains(@Nullable ItemStack var1)
                    TODO()
                }
                .function("contains", 2) {
                    // boolean contains(@NotNull Material var1, int var2)
                    // boolean contains(@Nullable ItemStack var1, int var2)
                    TODO()
                }
                .function("containsAtLeast", 2) {
                    it.target?.containsAtLeast(
                        it.getArgument(0) as ItemStack,
                        it.getNumber(1).toInt()
                    )
                }
                .function("first", 1) {
                    // int first(@NotNull Material var1)
                    // int first(@NotNull ItemStack var1)
                    TODO()
                }
                .function("firstEmpty", 0) { it.target?.firstEmpty() }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("remove", 1) {
                    // void remove(@NotNull Material var1)
                    // void remove(@NotNull ItemStack var1)
                    TODO()
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
