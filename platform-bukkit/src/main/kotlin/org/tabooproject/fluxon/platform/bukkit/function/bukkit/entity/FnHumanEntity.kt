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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.platform.util.sendActionBar


@Requires(classes = ["org.bukkit.entity.HumanEntity"])
@PlatformSide(Platform.BUKKIT)
object FnHumanEntity {

    val TYPE = Type.fromClass(HumanEntity::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HumanEntity::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("inventory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnPlayerInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("enderChest",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.enderChest) }
                .function("mainHand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnMainHand.TYPE).noParams()) { it.setReturnRef(it.target?.mainHand) }
                .function("setWindowProperty",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryViewProperty.TYPE, Type.I)) {
                    it.setReturnBool(it.target?.setWindowProperty(it.getRef(0) as InventoryView.Property, it.getInt(1).toInt()) == true)
                }
                .function("enchantmentSeed", returns(Type.I).noParams()) { it.setReturnInt(it.target?.enchantmentSeed ?: 0) }
                .function("setEnchantmentSeed", returnsVoid().params(Type.I)) { it.target?.setEnchantmentSeed(it.getInt(0).toInt()) }
                .syncFunction("openInventory",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryView.TYPE).noParams()) {
                    it.setReturnRef(it.target?.openInventory)
                }
                .syncFunction("openInventory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryView.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE)) { it.setReturnRef(it.target?.openInventory(it.getRef(0) as Inventory)) }
                .syncFunction("openInventory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryView.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryView.TYPE)) { it.setReturnRef(it.target?.openInventory(it.getRef(0) as InventoryView)) }
                .syncFunction("openWorkbench",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryView.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.Z)) {
                    it.setReturnRef(it.target?.openWorkbench(
                        it.getRef(0) as Location,
                        it.getBool(1)
                    ))
                }
                .syncFunction("openEnchanting",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryView.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.Z)) {
                    it.setReturnRef(it.target?.openEnchanting(
                        it.getRef(0) as Location,
                        it.getBool(1)
                    ))
                }
                .syncFunction("openMerchant", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryView.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnVillager.TYPE, Type.Z)) { it.setReturnRef(it.target?.openMerchant(it.getRef(0) as Villager, it.getBool(1))) }
                .syncFunction("openMerchant", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryView.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnMerchant.TYPE, Type.Z)) { it.setReturnRef(it.target?.openMerchant(it.getRef(0) as Merchant, it.getBool(1))) }
                .function("closeInventory", returnsVoid().noParams()) { it.target?.closeInventory() }
                .function("itemInHand",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemInHand) }
                .function("setItemInHand",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItemInHand(it.getRef(0) as ItemStack) }
                .function("itemOnCursor",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemOnCursor) }
                .function("setItemOnCursor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItemOnCursor(it.getRef(0) as ItemStack) }
                .function("hasCooldown",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.setReturnBool(it.target?.hasCooldown(it.getRef(0) as Material) ?: false) }
                .function("getCooldown",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.setReturnInt(it.target?.getCooldown(it.getRef(0) as Material) ?: 0)
                }
                .function("setCooldown",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.I)) {
                    it.target?.setCooldown(
                        it.getRef(0) as Material,
                        it.getInt(1).toInt()
                    )
                }
                .function("sleepTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.sleepTicks ?: 0) }
                .function("sleep",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.Z)) {
                    it.setReturnBool(it.target?.sleep(it.getRef(0) as Location, it.getBool(1)) == true)
                }
                .function("wakeup", returnsVoid().params(Type.Z)) { it.target?.wakeup(it.getBool(0)) }
                .function("bedLocation",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.bedLocation) }
                .function("gameMode",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnGameMode.TYPE).noParams()) { it.setReturnRef(it.target?.gameMode) }
                .function("setGameMode",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnGameMode.TYPE)) { it.target?.setGameMode(it.getRef(0) as GameMode) }
                .function("isBlocking", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBlocking ?: false) }
                .function("isHandRaised", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isHandRaised ?: false) }
                .function("expToLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.expToLevel ?: 0) }
                .function("attackCooldown", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.attackCooldown ?: 0f) }
                .function("discoverRecipe",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) {
                    it.setReturnBool(it.target?.discoverRecipe(it.getRef(0) as NamespacedKey) == true)
                }
                .function("discoverRecipes",returns(Type.I).params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION)) {
                    it.setReturnInt(it.target?.discoverRecipes(it.getRef(0) as Collection<NamespacedKey>) ?: 0)
                }
                .function("undiscoverRecipe",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) {
                    it.setReturnBool(it.target?.undiscoverRecipe(it.getRef(0) as NamespacedKey) == true)
                }
                .function("undiscoverRecipes",returns(Type.I).params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION)) {
                    it.setReturnInt(it.target?.undiscoverRecipes(it.getRef(0) as Collection<NamespacedKey>) ?: 0)
                }
                .function("hasDiscoveredRecipe",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnBool(it.target?.hasDiscoveredRecipe(it.getRef(0) as NamespacedKey) ?: false) }
                .function("discoveredRecipes",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.discoveredRecipes) }
                .function("shoulderEntityLeft",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.shoulderEntityLeft) }
                .function("setShoulderEntityLeft",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.target?.setShoulderEntityLeft(it.getRef(0) as Entity) }
                .function("shoulderEntityRight",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.shoulderEntityRight) }
                .function("setShoulderEntityRight",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.target?.setShoulderEntityRight(it.getRef(0) as Entity) }
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
                .function("lastDeathLocation",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.lastDeathLocation) }
                .function("setLastDeathLocation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.target?.setLastDeathLocation(it.getRef(0) as Location) }
                .function("fireworkBoost",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnFirework.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.setReturnRef(it.target?.fireworkBoost(it.getRef(0) as ItemStack)) }
                .function("sendActionBar", returnsVoid().params(Type.STRING)) { it.getString(0)?.let { message -> it.target?.sendActionBar(message) } }
        }
    }
}
