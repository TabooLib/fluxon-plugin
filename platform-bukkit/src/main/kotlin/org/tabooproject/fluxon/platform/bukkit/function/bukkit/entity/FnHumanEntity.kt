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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.entity.HumanEntity"])
@PlatformSide(Platform.BUKKIT)
object FnHumanEntity {

    val TYPE = Type.fromClass(HumanEntity::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HumanEntity::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("enderChest", returnsObject().noParams()) { it.setReturnRef(it.target?.enderChest) }
                .function("mainHand", returnsObject().noParams()) { it.setReturnRef(it.target?.mainHand) }
                .function("setWindowProperty", returns(Type.Z).params(Type.OBJECT, Type.I)) {
                    it.setReturnBool(it.target?.setWindowProperty(it.getRef(0) as InventoryView.Property, it.getInt(1).toInt()) == true)
                }
                .function("enchantmentSeed", returns(Type.I).noParams()) { it.setReturnInt(it.target?.enchantmentSeed ?: 0) }
                .function("setEnchantmentSeed", returnsVoid().params(Type.I)) { it.target?.setEnchantmentSeed(it.getInt(0).toInt()) }
                .syncFunction("openInventory", returnsObject().noParams()) {
                    it.setReturnRef(it.target?.openInventory)
                }
                .syncFunction("openInventory", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Inventory -> it.target?.openInventory(var1)
                        is InventoryView -> it.target?.openInventory(var1)
                        else -> throw IllegalArgumentException("参数必须是 Inventory 或 InventoryView 类型")
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
                .function("closeInventory", returnsVoid().noParams()) { it.target?.closeInventory() }
                .function("itemInHand", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInHand) }
                .function("setItemInHand", returnsVoid().params(Type.OBJECT)) { it.target?.setItemInHand(it.getRef(0) as ItemStack) }
                .function("itemOnCursor", returnsObject().noParams()) { it.setReturnRef(it.target?.itemOnCursor) }
                .function("setItemOnCursor", returnsVoid().params(Type.OBJECT)) { it.target?.setItemOnCursor(it.getRef(0) as ItemStack) }
                .function("hasCooldown", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.hasCooldown(it.getRef(0) as Material) ?: false) }
                .function("getCooldown", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(it.target?.getCooldown(it.getRef(0) as Material) ?: 0)
                }
                .function("setCooldown", returnsVoid().params(Type.OBJECT, Type.I)) {
                    it.target?.setCooldown(
                        it.getRef(0) as Material,
                        it.getInt(1).toInt()
                    )
                }
                .function("sleepTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.sleepTicks ?: 0) }
                .function("sleep", returns(Type.Z).params(Type.OBJECT, Type.Z)) {
                    it.setReturnBool(it.target?.sleep(it.getRef(0) as Location, it.getBool(1)) == true)
                }
                .function("wakeup", returnsVoid().params(Type.Z)) { it.target?.wakeup(it.getBool(0)) }
                .function("bedLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.bedLocation) }
                .function("gameMode", returnsObject().noParams()) { it.setReturnRef(it.target?.gameMode) }
                .function("setGameMode", returnsVoid().params(Type.OBJECT)) { it.target?.setGameMode(it.getRef(0) as GameMode) }
                .function("isBlocking", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBlocking ?: false) }
                .function("isHandRaised", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isHandRaised ?: false) }
                .function("expToLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.expToLevel ?: 0) }
                .function("attackCooldown", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.attackCooldown ?: 0f) }
                .function("discoverRecipe", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.discoverRecipe(it.getRef(0) as NamespacedKey) == true)
                }
                .function("discoverRecipes", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(it.target?.discoverRecipes(it.getRef(0) as Collection<NamespacedKey>) ?: 0)
                }
                .function("undiscoverRecipe", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.undiscoverRecipe(it.getRef(0) as NamespacedKey) == true)
                }
                .function("undiscoverRecipes", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(it.target?.undiscoverRecipes(it.getRef(0) as Collection<NamespacedKey>) ?: 0)
                }
                .function("hasDiscoveredRecipe", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.hasDiscoveredRecipe(it.getRef(0) as NamespacedKey) ?: false) }
                .function("discoveredRecipes", returnsObject().noParams()) { it.setReturnRef(it.target?.discoveredRecipes) }
                .function("shoulderEntityLeft", returnsObject().noParams()) { it.setReturnRef(it.target?.shoulderEntityLeft) }
                .function("setShoulderEntityLeft", returnsVoid().params(Type.OBJECT)) { it.target?.setShoulderEntityLeft(it.getRef(0) as Entity) }
                .function("shoulderEntityRight", returnsObject().noParams()) { it.setReturnRef(it.target?.shoulderEntityRight) }
                .function("setShoulderEntityRight", returnsVoid().params(Type.OBJECT)) { it.target?.setShoulderEntityRight(it.getRef(0) as Entity) }
                .function("dropItem", returns(Type.Z).params(Type.Z)) { it.setReturnBool(it.target?.dropItem(it.getBool(0)) == true) }
                .function("exhaustion", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.exhaustion ?: 0f) }
                .function("setExhaustion", returnsVoid().params(Type.F)) { it.target?.setExhaustion(it.getFloat(0)) }
                .function("saturation", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.saturation ?: 0f) }
                .function("setSaturation", returnsVoid().params(Type.F)) { it.target?.setSaturation(it.getFloat(0)) }
                .function("foodLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.foodLevel ?: 0) }
                .function("setFoodLevel", returnsVoid().params(Type.I)) { it.target?.setFoodLevel(it.getInt(0).toInt()) }
                .function("saturatedRegenRate", returns(Type.I).noParams()) { it.setReturnInt(it.target?.saturatedRegenRate ?: 0) }
                .function("setSaturatedRegenRate", returnsVoid().params(Type.I)) { it.target?.setSaturatedRegenRate(it.getInt(0).toInt()) }
                .function("unsaturatedRegenRate", returns(Type.I).noParams()) { it.setReturnInt(it.target?.unsaturatedRegenRate ?: 0) }
                .function("setUnsaturatedRegenRate", returnsVoid().params(Type.I)) { it.target?.setUnsaturatedRegenRate(it.getInt(0).toInt()) }
                .function("starvationRate", returns(Type.I).noParams()) { it.setReturnInt(it.target?.starvationRate ?: 0) }
                .function("setStarvationRate", returnsVoid().params(Type.I)) { it.target?.setStarvationRate(it.getInt(0).toInt()) }
                .function("lastDeathLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.lastDeathLocation) }
                .function("setLastDeathLocation", returnsVoid().params(Type.OBJECT)) { it.target?.setLastDeathLocation(it.getRef(0) as Location) }
                .function("fireworkBoost", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.fireworkBoost(it.getRef(0) as ItemStack)) }
        }
    }
}
