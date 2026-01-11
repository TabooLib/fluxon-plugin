package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.inventory.ItemFactory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnItemFactory {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemFactory::class.java)
                .function("itemMeta", 1) { it.target?.getItemMeta(it.getArgument(0) as Material) }
                .function("isApplicable", 2) {
                    // boolean isApplicable(@Nullable ItemMeta var1, @Nullable ItemStack var2)
                    // boolean isApplicable(@Nullable ItemMeta var1, @Nullable Material var2)
                    TODO()
                }
                .function("equals", 2) {
                    it.target?.equals(
                        it.getArgument(0) as ItemMeta,
                        it.getArgument(1) as ItemMeta
                    )
                }
                .function("asMetaFor", 2) {
                    // ItemMeta asMetaFor(@NotNull ItemMeta var1, @NotNull ItemStack var2)
                    // ItemMeta asMetaFor(@NotNull ItemMeta var1, @NotNull Material var2)
                    TODO()
                }
                .function("defaultLeatherColor", 0) { it.target?.defaultLeatherColor }
                .function("createItemStack", 1) { it.target?.createItemStack(it.getString(0)!!) }
                .function("spawnEgg", 1) { it.target?.getSpawnEgg(it.getArgument(0) as EntityType) }
                .function("enchantItem", 4) {
                    // ItemStack enchantItem(@NotNull Entity var1, @NotNull ItemStack var2, int var3, boolean var4)
                    // ItemStack enchantItem(@NotNull World var1, @NotNull ItemStack var2, int var3, boolean var4)
                    TODO()
                }
                .function("enchantItem", 3) {
                    it.target?.enchantItem(
                        it.getArgument(0) as ItemStack,
                        it.getNumber(1).toInt(),
                        it.getBoolean(2)
                    )
                }
        }
    }
}
