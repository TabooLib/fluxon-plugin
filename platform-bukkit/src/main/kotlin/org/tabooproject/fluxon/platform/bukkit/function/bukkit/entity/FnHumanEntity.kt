package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.HumanEntity
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
                // 只读属性
                .function("name", 0) { it.target?.name }
                .function("bedLocation", 0) { it.target?.bedLocation }
                .function("uuid", 0) { it.target?.uniqueId }
                .function("expToLevel", 0) { it.target?.expToLevel }
                .function("discoveredRecipes", 0) { it.target?.discoveredRecipes }
                .function("enderChest", 0) { it.target?.enderChest }
                .function("inventory", 0) { it.target?.inventory }
                .function("itemOnCursor", 0) { it.target?.itemOnCursor }
                .function("lastDeathLocation", 0) { it.target?.lastDeathLocation }
                .function("openInventory", 0) { it.target?.openInventory }
                .function("sleepTicks", 0) { it.target?.sleepTicks }
                .function("mainHand", 0) { it.target?.mainHand }
                .function("isBlocking", 0) { it.target?.isBlocking }
                .function("isHandRaised", 0) { it.target?.isHandRaised }

                // 可读写属性
                .function("gameMode", 0) { it.target?.gameMode }
                .syncFunction("setGameMode", 1) {
                    it.target?.apply {
                        gameMode = it.getString(0)?.let { mode -> GameMode.valueOf(mode) } ?: GameMode.SURVIVAL
                    }
                }
                .function("exhaustion", 0) { it.target?.exhaustion }
                .syncFunction("setExhaustion", 1) { it.target?.apply { exhaustion = it.getNumber(0).toFloat() } }
                .function("foodLevel", 0) { it.target?.foodLevel }
                .syncFunction("setFoodLevel", 1) { it.target?.apply { foodLevel = it.getNumber(0).toInt() } }
                .function("attackCooldown", 0) { it.target?.attackCooldown }

                .function("enchantmentSeed", 0) { it.target?.enchantmentSeed }
                .syncFunction("setEnchantmentSeed", 1) { it.target?.apply { enchantmentSeed = it.getNumber(0).toInt() } }

                .syncFunction("setLastDeathLocation", 1) { it.target?.apply { lastDeathLocation = it.getArgument(0) as? Location } }

                .function("starvationRate", 0) { it.target?.starvationRate }
                .syncFunction("setStarvationRate", 1) { it.target?.apply { starvationRate = it.getNumber(0).toInt() } }
                .function("saturatedRegenRate", 0) { it.target?.saturatedRegenRate }
                .syncFunction("setSaturatedRegenRate", 1) { it.target?.apply { saturatedRegenRate = it.getNumber(0).toInt() } }
                .function("unsaturatedRegenRate", 0) { it.target?.unsaturatedRegenRate }
                .syncFunction("setUnsaturatedRegenRate", 1) { it.target?.apply { unsaturatedRegenRate = it.getNumber(0).toInt() } }
                .function("saturation", 0) { it.target?.saturation }
                .syncFunction("setSaturation", 1) { it.target?.apply { saturation = it.getNumber(0).toFloat() } }

                .function("shoulderEntityLeft", 0) { it.target?.shoulderEntityLeft }
                .syncFunction("setShoulderEntityLeft", 1) { it.target?.apply { shoulderEntityLeft = it.getArgument(0) as? Entity } }
                .function("shoulderEntityRight", 0) { it.target?.shoulderEntityRight }
                .syncFunction("setShoulderEntityRight", 1) { it.target?.apply { shoulderEntityRight = it.getArgument(0) as? Entity } }
        }
    }
}
