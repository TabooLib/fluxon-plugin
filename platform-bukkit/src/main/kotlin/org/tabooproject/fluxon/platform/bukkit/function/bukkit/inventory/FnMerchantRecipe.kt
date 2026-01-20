package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.MerchantRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMerchantRecipe {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MerchantRecipe::class.java)
                .function("result", 0) { it.target?.result }
                .function("addIngredient", 1) { it.target?.addIngredient(it.getArgument(0) as ItemStack) }
                .function("removeIngredient", 1) { it.target?.removeIngredient(it.getNumber(0).toInt()) }
                .function("setIngredients", 1) { it.target?.setIngredients(it.getArgument(0) as List<ItemStack>) }
                .function("ingredients", 0) { it.target?.ingredients }
                .function("adjustedIngredient1", 0) { it.target?.adjustedIngredient1 }
                .function("adjust", 1) { it.target?.adjust(it.getArgument(0) as ItemStack) }
                .function("demand", 0) { it.target?.demand }
                .function("setDemand", 1) { it.target?.setDemand(it.getNumber(0).toInt()) }
                .function("specialPrice", 0) { it.target?.specialPrice }
                .function("setSpecialPrice", 1) { it.target?.setSpecialPrice(it.getNumber(0).toInt()) }
                .function("uses", 0) { it.target?.uses }
                .function("setUses", 1) { it.target?.setUses(it.getNumber(0).toInt()) }
                .function("maxUses", 0) { it.target?.maxUses }
                .function("setMaxUses", 1) { it.target?.setMaxUses(it.getNumber(0).toInt()) }
                .function("hasExperienceReward", 0) { it.target?.hasExperienceReward() }
                .function("setExperienceReward", 1) { it.target?.setExperienceReward(it.getBoolean(0)) }
                .function("villagerExperience", 0) { it.target?.villagerExperience }
                .function("setVillagerExperience", 1) { it.target?.setVillagerExperience(it.getNumber(0).toInt()) }
                .function("priceMultiplier", 0) { it.target?.priceMultiplier }
                .function("setPriceMultiplier", 1) { it.target?.setPriceMultiplier(it.getNumber(0).toFloat()) }
        }
    }
}
