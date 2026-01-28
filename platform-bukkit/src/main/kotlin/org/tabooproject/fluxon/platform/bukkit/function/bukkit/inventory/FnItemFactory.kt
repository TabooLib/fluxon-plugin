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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.ItemFactory"])
@PlatformSide(Platform.BUKKIT)
object FnItemFactory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemFactory::class.java)
                .function("getItemMeta", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getItemMeta(it.getRef(0) as Material)) }
                .function("isApplicable", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var2 = it.getRef(1)) {
                        is ItemStack -> it.target?.isApplicable(it.getRef(0) as ItemMeta, var2)
                        is Material -> it.target?.isApplicable(it.getRef(0) as ItemMeta, var2)
                        else -> throw IllegalArgumentException("参数 2 必须是 ItemStack 或 Material 类型")
                    })
                }
                .function("equals", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.equals(
                        it.getRef(0) as ItemMeta,
                        it.getRef(1) as ItemMeta
                    ))
                }
                .function("asMetaFor", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var2 = it.getRef(1)) {
                        is ItemStack -> it.target?.asMetaFor(it.getRef(0) as ItemMeta, var2)
                        is Material -> it.target?.asMetaFor(it.getRef(0) as ItemMeta, var2)
                        else -> throw IllegalArgumentException("参数 2 必须是 ItemStack 或 Material 类型")
                    })
                }
                .function("defaultLeatherColor", returnsObject().noParams()) { it.setReturnRef(it.target?.defaultLeatherColor) }
                .function("createItemStack", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.createItemStack(it.getString(0)!!)) }
                .function("getSpawnEgg", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getSpawnEgg(it.getRef(0) as EntityType)) }
                .function("enchantItem", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 3) {
                        it.target?.enchantItem(
                            it.getRef(0) as ItemStack,
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Entity -> it.target?.enchantItem(
                                var1,
                                it.getRef(1) as ItemStack,
                                it.getInt(2).toInt(),
                                it.getBool(3)
                            )

                            is World -> it.target?.enchantItem(
                                var1,
                                it.getRef(1) as ItemStack,
                                it.getInt(2).toInt(),
                                it.getBool(3)
                            )

                            else -> throw IllegalArgumentException("参数 1 必须是 Entity 或 World 类型")
                        }
                    })
                }
                .function("enchantItem", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 3) {
                        it.target?.enchantItem(
                            it.getRef(0) as ItemStack,
                            it.getInt(1).toInt(),
                            it.getBool(2)
                        )
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Entity -> it.target?.enchantItem(
                                var1,
                                it.getRef(1) as ItemStack,
                                it.getInt(2).toInt(),
                                it.getBool(3)
                            )

                            is World -> it.target?.enchantItem(
                                var1,
                                it.getRef(1) as ItemStack,
                                it.getInt(2).toInt(),
                                it.getBool(3)
                            )

                            else -> throw IllegalArgumentException("参数 1 必须是 Entity 或 World 类型")
                        }
                    })
                }
        }
    }
}
