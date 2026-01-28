package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.Merchant
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

@Requires(classes = ["org.bukkit.inventory.Merchant"])
@PlatformSide(Platform.BUKKIT)
object FnMerchant {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Merchant::class.java)
                .function("recipes", returnsObject().noParams()) { it.setReturnRef(it.target?.recipes) }
                .function("setRecipes", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRecipes(it.getRef(0) as List<MerchantRecipe>)) }
                .function("getRecipe", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getRecipe(it.getInt(0).toInt())) }
                .function("setRecipe", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setRecipe(
                        it.getInt(0).toInt(),
                        it.getRef(1) as MerchantRecipe
                    ))
                }
                .function("recipeCount", returnsObject().noParams()) { it.setReturnRef(it.target?.recipeCount) }
                .function("isTrading", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isTrading) }
                .function("trader", returnsObject().noParams()) { it.setReturnRef(it.target?.trader) }
        }
    }
}
