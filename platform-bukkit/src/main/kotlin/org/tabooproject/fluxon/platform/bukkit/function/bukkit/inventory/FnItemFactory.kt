package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.World
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.inventory.ItemFactory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnItemFactory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemFactory::class.java)
                .function("getItemMeta", 1) { it.target?.getItemMeta(it.getArgument(0) as Material) }
                .function("isApplicable", 2) {
                    when (val var2 = it.getArgument(1)) {
                        is ItemStack -> it.target?.isApplicable(it.getArgument(0) as ItemMeta, var2)
                        is Material -> it.target?.isApplicable(it.getArgument(0) as ItemMeta, var2)
                        else -> throw IllegalArgumentException("参数 2 必须是 ItemStack 或 Material 类型")
                    }
                }
                .function("equals", 2) {
                    it.target?.equals(
                        it.getArgument(0) as ItemMeta,
                        it.getArgument(1) as ItemMeta
                    )
                }
                .function("asMetaFor", 2) {
                    when (val var2 = it.getArgument(1)) {
                        is ItemStack -> it.target?.asMetaFor(it.getArgument(0) as ItemMeta, var2)
                        is Material -> it.target?.asMetaFor(it.getArgument(0) as ItemMeta, var2)
                        else -> throw IllegalArgumentException("参数 2 必须是 ItemStack 或 Material 类型")
                    }
                }
                .function("defaultLeatherColor", 0) { it.target?.defaultLeatherColor }
                .function("createItemStack", 1) { it.target?.createItemStack(it.getString(0)!!) }
                .function("getSpawnEgg", 1) { it.target?.getSpawnEgg(it.getArgument(0) as EntityType) }
                .function("enchantItem", listOf(3, 4)) {
                    if (it.arguments.size == 3) {
                        it.target?.enchantItem(
                            it.getArgument(0) as ItemStack,
                            it.getNumber(1).toInt(),
                            it.getBoolean(2)
                        )
                    } else {
                        when (val var1 = it.getArgument(0)) {
                            is Entity -> it.target?.enchantItem(
                                var1,
                                it.getArgument(1) as ItemStack,
                                it.getNumber(2).toInt(),
                                it.getBoolean(3)
                            )

                            is World -> it.target?.enchantItem(
                                var1,
                                it.getArgument(1) as ItemStack,
                                it.getNumber(2).toInt(),
                                it.getBoolean(3)
                            )

                            else -> throw IllegalArgumentException("参数 1 必须是 Entity 或 World 类型")
                        }
                    }
                }
        }
    }
}
