package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Entity
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Villager
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryView
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Merchant
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.entity.HumanEntity"])
@PlatformSide(Platform.BUKKIT)
object FnHumanEntity {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HumanEntity::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("enderChest", returnsObject().noParams()) { it.setReturnRef(it.target?.enderChest) }
                .function("mainHand", returnsObject().noParams()) { it.setReturnRef(it.target?.mainHand) }
                .function("setWindowProperty", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.setWindowProperty(it.getRef(0) as InventoryView.Property, it.getInt(1).toInt())) }
                .function("enchantmentSeed", returnsObject().noParams()) { it.setReturnRef(it.target?.enchantmentSeed) }
                .function("setEnchantmentSeed", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEnchantmentSeed(it.getInt(0).toInt())) }
                .syncFunction("openInventory", returnsObject().noParams()) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.openInventory
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Inventory -> it.target?.openInventory(var1)
                            is InventoryView -> it.target?.openInventory(var1)
                            else -> throw IllegalArgumentException("参数必须是 Inventory 或 InventoryView 类型")
                        }
                    })
                }
                .syncFunction("openInventory", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.openInventory
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Inventory -> it.target?.openInventory(var1)
                            is InventoryView -> it.target?.openInventory(var1)
                            else -> throw IllegalArgumentException("参数必须是 Inventory 或 InventoryView 类型")
                        }
                    })
                }
                .syncFunction("openWorkbench", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.openWorkbench(
                        it.getRef(0) as Location,
                        it.getBool(1)
                    ))
                }
                .syncFunction("openEnchanting", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.openEnchanting(
                        it.getRef(0) as Location,
                        it.getBool(1)
                    ))
                }
                .syncFunction("openMerchant", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Villager -> it.target?.openMerchant(var1, it.getBool(1))
                        is Merchant -> it.target?.openMerchant(var1, it.getBool(1))
                        else -> throw IllegalArgumentException("参数必须是 Villager 或 Merchant 类型")
                    })
                }
                .function("closeInventory", returnsObject().noParams()) { it.setReturnRef(it.target?.closeInventory()) }
                .function("itemInHand", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInHand) }
                .function("setItemInHand", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItemInHand(it.getRef(0) as ItemStack)) }
                .function("itemOnCursor", returnsObject().noParams()) { it.setReturnRef(it.target?.itemOnCursor) }
                .function("setItemOnCursor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItemOnCursor(it.getRef(0) as ItemStack)) }
                .function("hasCooldown", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasCooldown(it.getRef(0) as Material)) }
                .function("getCooldown", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getCooldown(it.getRef(0) as Material)) }
                .function("setCooldown", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setCooldown(
                        it.getRef(0) as Material,
                        it.getInt(1).toInt()
                    ))
                }
                .function("sleepTicks", returnsObject().noParams()) { it.setReturnRef(it.target?.sleepTicks) }
                .function("sleep", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.sleep(it.getRef(0) as Location, it.getBool(1))) }
                .function("wakeup", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.wakeup(it.getBool(0))) }
                .function("bedLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.bedLocation) }
                .function("gameMode", returnsObject().noParams()) { it.setReturnRef(it.target?.gameMode) }
                .function("setGameMode", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setGameMode(it.getRef(0) as GameMode)) }
                .function("isBlocking", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isBlocking) }
                .function("isHandRaised", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isHandRaised) }
                .function("expToLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.expToLevel) }
                .function("attackCooldown", returnsObject().noParams()) { it.setReturnRef(it.target?.attackCooldown) }
                .function("discoverRecipe", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.discoverRecipe(it.getRef(0) as NamespacedKey)) }
                .function("discoverRecipes", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.discoverRecipes(it.getRef(0) as Collection<NamespacedKey>)) }
                .function("undiscoverRecipe", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.undiscoverRecipe(it.getRef(0) as NamespacedKey)) }
                .function("undiscoverRecipes", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.undiscoverRecipes(it.getRef(0) as Collection<NamespacedKey>)) }
                .function("hasDiscoveredRecipe", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasDiscoveredRecipe(it.getRef(0) as NamespacedKey)) }
                .function("discoveredRecipes", returnsObject().noParams()) { it.setReturnRef(it.target?.discoveredRecipes) }
                .function("shoulderEntityLeft", returnsObject().noParams()) { it.setReturnRef(it.target?.shoulderEntityLeft) }
                .function("setShoulderEntityLeft", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setShoulderEntityLeft(it.getRef(0) as Entity)) }
                .function("shoulderEntityRight", returnsObject().noParams()) { it.setReturnRef(it.target?.shoulderEntityRight) }
                .function("setShoulderEntityRight", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setShoulderEntityRight(it.getRef(0) as Entity)) }
                .function("dropItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.dropItem(it.getBool(0))) }
                .function("exhaustion", returnsObject().noParams()) { it.setReturnRef(it.target?.exhaustion) }
                .function("setExhaustion", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setExhaustion(it.getFloat(0))) }
                .function("saturation", returnsObject().noParams()) { it.setReturnRef(it.target?.saturation) }
                .function("setSaturation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSaturation(it.getFloat(0))) }
                .function("foodLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.foodLevel) }
                .function("setFoodLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFoodLevel(it.getInt(0).toInt())) }
                .function("saturatedRegenRate", returnsObject().noParams()) { it.setReturnRef(it.target?.saturatedRegenRate) }
                .function("setSaturatedRegenRate", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSaturatedRegenRate(it.getInt(0).toInt())) }
                .function("unsaturatedRegenRate", returnsObject().noParams()) { it.setReturnRef(it.target?.unsaturatedRegenRate) }
                .function("setUnsaturatedRegenRate", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setUnsaturatedRegenRate(it.getInt(0).toInt())) }
                .function("starvationRate", returnsObject().noParams()) { it.setReturnRef(it.target?.starvationRate) }
                .function("setStarvationRate", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setStarvationRate(it.getInt(0).toInt())) }
                .function("lastDeathLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.lastDeathLocation) }
                .function("setLastDeathLocation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLastDeathLocation(it.getRef(0) as Location)) }
                .function("fireworkBoost", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.fireworkBoost(it.getRef(0) as ItemStack)) }
        }
    }
}
