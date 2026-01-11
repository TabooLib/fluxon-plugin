package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.UnsafeValues
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.PluginDescriptionFile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnUnsafeValues {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(UnsafeValues::class.java)
                .function("toLegacy", 1) { it.target?.toLegacy(it.getArgument(0) as Material) }
                .function("fromLegacy", 1) {
                    // Material fromLegacy(Material var1)
                    // Material fromLegacy(MaterialData var1)
                    TODO()
                }
                .function("fromLegacy", 2) {
                    // Material fromLegacy(MaterialData var1, boolean var2)
                    // BlockData fromLegacy(Material var1, byte var2)
                    TODO()
                }
                .function("material", 2) { it.target?.getMaterial(it.getString(0), it.getNumber(1).toInt()) }
                .function("dataVersion", 0) { it.target?.dataVersion }
                .function("modifyItemStack", 2) {
                    it.target?.modifyItemStack(
                        it.getArgument(0) as ItemStack,
                        it.getString(1)
                    )
                }
                .function("checkSupported", 1) { it.target?.checkSupported(it.getArgument(0) as PluginDescriptionFile) }
                .function("processClass", 3) {
                    it.target?.processClass(
                        it.getArgument(0) as PluginDescriptionFile,
                        it.getString(1),
                        it.getArgument(2) as ByteArray
                    )
                }
                .function("loadAdvancement", 2) {
                    it.target?.loadAdvancement(
                        it.getArgument(0) as NamespacedKey,
                        it.getString(1)
                    )
                }
                .function("removeAdvancement", 1) { it.target?.removeAdvancement(it.getArgument(0) as NamespacedKey) }
                .function("creativeCategory", 1) { it.target?.getCreativeCategory(it.getArgument(0) as Material) }
                .function("blockTranslationKey", 1) { it.target?.getBlockTranslationKey(it.getArgument(0) as Material) }
                .function("itemTranslationKey", 1) { it.target?.getItemTranslationKey(it.getArgument(0) as Material) }
                .function("translationKey", 1) {
                    // String getTranslationKey(EntityType var1)
                    // String getTranslationKey(ItemStack var1)
                    // String getTranslationKey(Attribute var1)
                    TODO()
                }
                .function("featureFlag", 1) { it.target?.getFeatureFlag(it.getArgument(0) as NamespacedKey) }
        }
    }
}
