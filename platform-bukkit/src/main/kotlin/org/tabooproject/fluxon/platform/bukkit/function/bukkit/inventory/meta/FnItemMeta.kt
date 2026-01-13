package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.ItemMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


/**
 * FluxonPlugin
 * org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory.FnItemMeta
 *
 * @author mical
 * @since 2026/1/4 12:10
 */
@PlatformSide(Platform.BUKKIT)
object FnItemMeta {

    @Suppress("unchecked_cast")
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            // TODO: 补全
            registerExtension(ItemMeta::class.java)
                .function("displayName", 0) { it.target?.displayName }
                .function("hasDisplayName", 0) { it.target?.hasDisplayName() }
                .syncFunction("setDisplayName", 1) { it.target?.setDisplayName(it.getString(0)) }
                .function("lore", 0) { it.target?.lore }
                .function("hasLore", 0) { it.target?.hasLore() }
                .syncFunction("setLore", 1) { it.target?.apply { lore = it.getArgument(0) as List<String> } }
                .function("enchants", 0) { it.target?.enchants }
                .function("hasEnchants", 0) { it.target?.hasEnchants() }
                .function("flags", 0) { it.target?.itemFlags }
                .function("hasFlags", 0) { it.target?.itemFlags?.isNotEmpty() }
                .function("customModelData", 0) { it.target?.customModelData }
                .function("hasCustomModelData", 0) { it.target?.hasCustomModelData() }
                .function("hasAttributeModifiers", 0) { it.target?.hasAttributeModifiers() }
                .function("unbreakable", 0) { it.target?.isUnbreakable }
                .function("localizedName", 0) { it.target?.localizedName }
                .function("hasLocalizedName", 0) { it.target?.hasLocalizedName() }
        }
    }
}

