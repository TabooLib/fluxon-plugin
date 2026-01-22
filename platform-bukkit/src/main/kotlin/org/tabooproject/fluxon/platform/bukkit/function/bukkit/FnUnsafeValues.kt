package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.UnsafeValues
import org.bukkit.attribute.Attribute
import org.bukkit.entity.EntityType
import org.bukkit.inventory.ItemStack
import org.bukkit.material.MaterialData
import org.bukkit.plugin.PluginDescriptionFile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnUnsafeValues {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(UnsafeValues::class.java)
                .function("toLegacy", 1) { it.target?.toLegacy(it.getArgument(0) as Material) }
                .function("fromLegacy", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is Material -> it.target?.fromLegacy(var1)
                            is MaterialData -> it.target?.fromLegacy(var1)
                            else -> throw IllegalArgumentException("参数必须是 Material 或 MaterialData 类型")
                        }
                    } else {
                        when (val var1 = it.getArgument(0)) {
                            is MaterialData -> it.target?.fromLegacy(var1, it.getBoolean(1))
                            is Material -> it.target?.fromLegacy(var1, it.getNumber(1).toByte())
                            else -> throw IllegalArgumentException("参数 1 必须是 MaterialData 或 Material 类型")
                        }
                    }
                }
                .function("getMaterial", 2) { it.target?.getMaterial(it.getString(0), it.getNumber(1).toInt()) }
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
                .function("getCreativeCategory", 1) { it.target?.getCreativeCategory(it.getArgument(0) as Material) }
                .function("getBlockTranslationKey", 1) { it.target?.getBlockTranslationKey(it.getArgument(0) as Material) }
                .function("getItemTranslationKey", 1) { it.target?.getItemTranslationKey(it.getArgument(0) as Material) }
                .function("getTranslationKey", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is EntityType -> it.target?.getTranslationKey(var1)
                        is ItemStack -> it.target?.getTranslationKey(var1)
                        is Attribute -> it.target?.getTranslationKey(var1)
                        else -> throw IllegalArgumentException("参数必须是 EntityType, ItemStack, 或 Attribute 类型")
                    }
                }
                .function("getFeatureFlag", 1) { it.target?.getFeatureFlag(it.getArgument(0) as NamespacedKey) }
        }
    }
}
