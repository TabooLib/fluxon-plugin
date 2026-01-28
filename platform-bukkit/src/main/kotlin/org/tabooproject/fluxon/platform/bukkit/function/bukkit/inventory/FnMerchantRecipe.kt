package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.MerchantRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.MerchantRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnMerchantRecipe {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MerchantRecipe::class.java)
                .function("result", returnsObject().noParams()) { it.setReturnRef(it.target?.result) }
                .function("addIngredient", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addIngredient(it.getRef(0) as ItemStack)) }
                .function("removeIngredient", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeIngredient(it.getInt(0).toInt())) }
                .function("setIngredients", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setIngredients(it.getRef(0) as List<ItemStack>)) }
                .function("ingredients", returnsObject().noParams()) { it.setReturnRef(it.target?.ingredients) }
                .function("adjustedIngredient1", returnsObject().noParams()) { it.setReturnRef(it.target?.adjustedIngredient1) }
                .function("adjust", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.adjust(it.getRef(0) as ItemStack)) }
                .function("demand", returnsObject().noParams()) { it.setReturnRef(it.target?.demand) }
                .function("setDemand", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDemand(it.getInt(0).toInt())) }
                .function("specialPrice", returnsObject().noParams()) { it.setReturnRef(it.target?.specialPrice) }
                .function("setSpecialPrice", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpecialPrice(it.getInt(0).toInt())) }
                .function("uses", returnsObject().noParams()) { it.setReturnRef(it.target?.uses) }
                .function("setUses", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setUses(it.getInt(0).toInt())) }
                .function("maxUses", returnsObject().noParams()) { it.setReturnRef(it.target?.maxUses) }
                .function("setMaxUses", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxUses(it.getInt(0).toInt())) }
                .function("hasExperienceReward", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasExperienceReward()) }
                .function("setExperienceReward", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setExperienceReward(it.getBool(0))) }
                .function("villagerExperience", returnsObject().noParams()) { it.setReturnRef(it.target?.villagerExperience) }
                .function("setVillagerExperience", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setVillagerExperience(it.getInt(0).toInt())) }
                .function("priceMultiplier", returnsObject().noParams()) { it.setReturnRef(it.target?.priceMultiplier) }
                .function("setPriceMultiplier", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPriceMultiplier(it.getFloat(0))) }
        }
    }
}
