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


@PlatformSide(Platform.BUKKIT)
object FnHumanEntity {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HumanEntity::class.java)
                .function("name", 0) { it.target?.name }
                .function("inventory", 0) { it.target?.inventory }
                .function("enderChest", 0) { it.target?.enderChest }
                .function("mainHand", 0) { it.target?.mainHand }
                .function(
                    "setWindowProperty",
                    2
                ) { it.target?.setWindowProperty(it.getArgument(0) as InventoryView.Property, it.getNumber(1).toInt()) }
                .function("enchantmentSeed", 0) { it.target?.enchantmentSeed }
                .function("setEnchantmentSeed", 1) { it.target?.setEnchantmentSeed(it.getNumber(0).toInt()) }
                .syncFunction("openInventory", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.openInventory
                    } else {
                        when (val var1 = it.getArgument(0)) {
                            is Inventory -> it.target?.openInventory(var1)
                            is InventoryView -> it.target?.openInventory(var1)
                            else -> throw IllegalArgumentException("参数必须是 Inventory 或 InventoryView 类型")
                        }
                    }
                }
                .syncFunction("openWorkbench", 2) {
                    it.target?.openWorkbench(
                        it.getArgument(0) as Location,
                        it.getBoolean(1)
                    )
                }
                .syncFunction("openEnchanting", 2) {
                    it.target?.openEnchanting(
                        it.getArgument(0) as Location,
                        it.getBoolean(1)
                    )
                }
                .syncFunction("openMerchant", 2) {
                    when (val var1 = it.getArgument(0)) {
                        is Villager -> it.target?.openMerchant(var1, it.getBoolean(1))
                        is Merchant -> it.target?.openMerchant(var1, it.getBoolean(1))
                        else -> throw IllegalArgumentException("参数必须是 Villager 或 Merchant 类型")
                    }
                }
                .function("closeInventory", 0) { it.target?.closeInventory() }
                .function("itemInHand", 0) { it.target?.itemInHand }
                .function("setItemInHand", 1) { it.target?.setItemInHand(it.getArgument(0) as ItemStack) }
                .function("itemOnCursor", 0) { it.target?.itemOnCursor }
                .function("setItemOnCursor", 1) { it.target?.setItemOnCursor(it.getArgument(0) as ItemStack) }
                .function("hasCooldown", 1) { it.target?.hasCooldown(it.getArgument(0) as Material) }
                .function("getCooldown", 1) { it.target?.getCooldown(it.getArgument(0) as Material) }
                .function("setCooldown", 2) {
                    it.target?.setCooldown(
                        it.getArgument(0) as Material,
                        it.getNumber(1).toInt()
                    )
                }
                .function("sleepTicks", 0) { it.target?.sleepTicks }
                .function("sleep", 2) { it.target?.sleep(it.getArgument(0) as Location, it.getBoolean(1)) }
                .function("wakeup", 1) { it.target?.wakeup(it.getBoolean(0)) }
                .function("bedLocation", 0) { it.target?.bedLocation }
                .function("gameMode", 0) { it.target?.gameMode }
                .function("setGameMode", 1) { it.target?.setGameMode(it.getArgument(0) as GameMode) }
                .function("isBlocking", 0) { it.target?.isBlocking }
                .function("isHandRaised", 0) { it.target?.isHandRaised }
                .function("expToLevel", 0) { it.target?.expToLevel }
                .function("attackCooldown", 0) { it.target?.attackCooldown }
                .function("discoverRecipe", 1) { it.target?.discoverRecipe(it.getArgument(0) as NamespacedKey) }
                .function(
                    "discoverRecipes",
                    1
                ) { it.target?.discoverRecipes(it.getArgument(0) as Collection<NamespacedKey>) }
                .function("undiscoverRecipe", 1) { it.target?.undiscoverRecipe(it.getArgument(0) as NamespacedKey) }
                .function(
                    "undiscoverRecipes",
                    1
                ) { it.target?.undiscoverRecipes(it.getArgument(0) as Collection<NamespacedKey>) }
                .function(
                    "hasDiscoveredRecipe",
                    1
                ) { it.target?.hasDiscoveredRecipe(it.getArgument(0) as NamespacedKey) }
                .function("discoveredRecipes", 0) { it.target?.discoveredRecipes }
                .function("shoulderEntityLeft", 0) { it.target?.shoulderEntityLeft }
                .function("setShoulderEntityLeft", 1) { it.target?.setShoulderEntityLeft(it.getArgument(0) as Entity) }
                .function("shoulderEntityRight", 0) { it.target?.shoulderEntityRight }
                .function(
                    "setShoulderEntityRight",
                    1
                ) { it.target?.setShoulderEntityRight(it.getArgument(0) as Entity) }
                .function("dropItem", 1) { it.target?.dropItem(it.getBoolean(0)) }
                .function("exhaustion", 0) { it.target?.exhaustion }
                .function("setExhaustion", 1) { it.target?.setExhaustion(it.getNumber(0).toFloat()) }
                .function("saturation", 0) { it.target?.saturation }
                .function("setSaturation", 1) { it.target?.setSaturation(it.getNumber(0).toFloat()) }
                .function("foodLevel", 0) { it.target?.foodLevel }
                .function("setFoodLevel", 1) { it.target?.setFoodLevel(it.getNumber(0).toInt()) }
                .function("saturatedRegenRate", 0) { it.target?.saturatedRegenRate }
                .function("setSaturatedRegenRate", 1) { it.target?.setSaturatedRegenRate(it.getNumber(0).toInt()) }
                .function("unsaturatedRegenRate", 0) { it.target?.unsaturatedRegenRate }
                .function("setUnsaturatedRegenRate", 1) { it.target?.setUnsaturatedRegenRate(it.getNumber(0).toInt()) }
                .function("starvationRate", 0) { it.target?.starvationRate }
                .function("setStarvationRate", 1) { it.target?.setStarvationRate(it.getNumber(0).toInt()) }
                .function("lastDeathLocation", 0) { it.target?.lastDeathLocation }
                .function("setLastDeathLocation", 1) { it.target?.setLastDeathLocation(it.getArgument(0) as Location) }
                .function("fireworkBoost", 1) { it.target?.fireworkBoost(it.getArgument(0) as ItemStack) }
        }
    }
}
