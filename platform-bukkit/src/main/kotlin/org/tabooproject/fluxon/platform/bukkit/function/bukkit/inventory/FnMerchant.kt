package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.Merchant
import org.bukkit.inventory.MerchantRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMerchant {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Merchant::class.java)
                .function("recipes", 0) { it.target?.recipes }
                .function("setRecipes", 1) { it.target?.setRecipes(it.getArgument(0) as List<MerchantRecipe>) }
                .function("getRecipe", 1) { it.target?.getRecipe(it.getNumber(0).toInt()) }
                .function("setRecipe", 2) {
                    it.target?.setRecipe(
                        it.getNumber(0).toInt(),
                        it.getArgument(1) as MerchantRecipe
                    )
                }
                .function("recipeCount", 0) { it.target?.recipeCount }
                .function("isTrading", 0) { it.target?.isTrading }
                .function("trader", 0) { it.target?.trader }
        }
    }
}
