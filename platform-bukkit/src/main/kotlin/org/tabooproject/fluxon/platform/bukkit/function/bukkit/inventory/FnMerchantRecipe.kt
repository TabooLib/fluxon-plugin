package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.MerchantRecipe
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

@Requires(classes = ["org.bukkit.inventory.MerchantRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnMerchantRecipe {

    val TYPE = Type.fromClass(MerchantRecipe::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MerchantRecipe::class.java)
                .function("result",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.result) }
                .function("addIngredient",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.addIngredient(it.getRef(0) as ItemStack) }
                .function("removeIngredient", returnsVoid().params(Type.I)) { it.target?.removeIngredient(it.getInt(0)) }
                .function("setIngredients",returnsVoid().params(Type.LIST)) { it.target?.setIngredients(it.getRef(0) as List<ItemStack>) }
                .function("ingredients",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.ingredients) }
                .function("adjustedIngredient1",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.adjustedIngredient1) }
                .function("adjust",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.adjust(it.getRef(0) as ItemStack) }
                .function("demand", returns(Type.I).noParams()) { it.setReturnInt(it.target?.demand ?: 0) }
                .function("setDemand", returnsVoid().params(Type.I)) { it.target?.setDemand(it.getInt(0)) }
                .function("specialPrice", returns(Type.I).noParams()) { it.setReturnInt(it.target?.specialPrice ?: 0) }
                .function("setSpecialPrice", returnsVoid().params(Type.I)) { it.target?.setSpecialPrice(it.getInt(0)) }
                .function("uses", returns(Type.I).noParams()) { it.setReturnInt(it.target?.uses ?: 0) }
                .function("setUses", returnsVoid().params(Type.I)) { it.target?.setUses(it.getInt(0)) }
                .function("maxUses", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxUses ?: 0) }
                .function("setMaxUses", returnsVoid().params(Type.I)) { it.target?.setMaxUses(it.getInt(0)) }
                .function("hasExperienceReward", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasExperienceReward() ?: false) }
                .function("setExperienceReward", returnsVoid().params(Type.Z)) { it.target?.setExperienceReward(it.getBool(0)) }
                .function("villagerExperience", returns(Type.I).noParams()) { it.setReturnInt(it.target?.villagerExperience ?: 0) }
                .function("setVillagerExperience", returnsVoid().params(Type.I)) { it.target?.setVillagerExperience(it.getInt(0)) }
                .function("priceMultiplier", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.priceMultiplier ?: 0f) }
                .function("setPriceMultiplier", returnsVoid().params(Type.F)) { it.target?.setPriceMultiplier(it.getFloat(0)) }
        }
    }
}
