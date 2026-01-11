package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.ShapedRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnShapedRecipe {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShapedRecipe::class.java)
                .function("shape", 0) {
                    // ShapedRecipe shape(String ... shape)
                    // String[] getShape()
                    TODO()
                }
                .function("setIngredient", 2) {
                    // ShapedRecipe setIngredient(char key, @NotNull MaterialData ingredient)
                    // ShapedRecipe setIngredient(char key, @NotNull Material ingredient)
                    // ShapedRecipe setIngredient(char key, @NotNull RecipeChoice ingredient)
                    TODO()
                }
                .function("setIngredient", 3) {
                    it.target?.setIngredient(
                        it.getString(0)?.firstOrNull()!!,
                        it.getArgument(1) as Material,
                        it.getNumber(2).toInt()
                    )
                }
        }
    }
}
