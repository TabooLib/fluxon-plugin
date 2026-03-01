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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.ItemFactory"])
@PlatformSide(Platform.BUKKIT)
object FnItemFactory {

    val TYPE = Type.fromClass(ItemFactory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemFactory::class.java)
                .function("getItemMeta", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnItemMeta.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) {
                    it.setReturnRef(it.target?.getItemMeta(it.getRef(0) as Material))
                }
                .function("isApplicable", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnItemMeta.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.setReturnBool(it.target?.isApplicable(it.getRef(0) as ItemMeta, it.getRef(1) as ItemStack) ?: false)
                }
                .function("isApplicable", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnItemMeta.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) {
                    it.setReturnBool(it.target?.isApplicable(it.getRef(0) as ItemMeta, it.getRef(1) as Material) ?: false)
                }
                .function("asMetaFor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnItemMeta.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnItemMeta.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.setReturnRef(it.target?.asMetaFor(it.getRef(0) as ItemMeta, it.getRef(1) as ItemStack))
                }
                .function("asMetaFor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnItemMeta.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnItemMeta.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) {
                    it.setReturnRef(it.target?.asMetaFor(it.getRef(0) as ItemMeta, it.getRef(1) as Material))
                }
                .function("defaultLeatherColor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.defaultLeatherColor) }
                .function("createItemStack", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.createItemStack(it.getString(0)!!)) }
                .function("getSpawnEgg", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) {
                    it.setReturnRef(it.target?.getSpawnEgg(it.getRef(0) as EntityType))
                }
                .function("enchantItem", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.I, Type.Z)) {
                    it.setReturnRef(it.target?.enchantItem(
                        it.getRef(0) as ItemStack,
                        it.getInt(1).toInt(),
                        it.getBool(2)
                    ))
                }
                .function("enchantItem", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.I, Type.Z)) {
                    it.setReturnRef(it.target?.enchantItem(
                        it.getRef(0) as Entity,
                        it.getRef(1) as ItemStack,
                        it.getInt(2).toInt(),
                        it.getBool(3)
                    ))
                }
                .function("enchantItem", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.I, Type.Z)) {
                    it.setReturnRef(it.target?.enchantItem(
                        it.getRef(0) as World,
                        it.getRef(1) as ItemStack,
                        it.getInt(2).toInt(),
                        it.getBool(3)
                    ))
                }
        }
    }
}
