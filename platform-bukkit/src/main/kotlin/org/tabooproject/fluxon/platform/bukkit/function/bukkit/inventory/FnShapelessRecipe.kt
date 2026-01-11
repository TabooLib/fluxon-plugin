package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.ShapelessRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnShapelessRecipe {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShapelessRecipe::class.java)
                .function("addIngredient", 1) {
                    // ShapelessRecipe addIngredient(@NotNull MaterialData ingredient)
                    // ShapelessRecipe addIngredient(@NotNull Material ingredient)
                    // ShapelessRecipe addIngredient(@NotNull RecipeChoice ingredient)
                    TODO()
                }
                .function("addIngredient", 2) {
                    // ShapelessRecipe addIngredient(@NotNull Material ingredient, int rawdata)
                    // ShapelessRecipe addIngredient(int count, @NotNull MaterialData ingredient)
                    // ShapelessRecipe addIngredient(int count, @NotNull Material ingredient)
                    TODO()
                }
                .function("addIngredient", 3) {
                    it.target?.addIngredient(
                        it.getNumber(0).toInt(),
                        it.getArgument(1) as Material,
                        it.getNumber(2).toInt()
                    )
                }
                .function("removeIngredient", 1) {
                    // ShapelessRecipe removeIngredient(@NotNull RecipeChoice ingredient)
                    // ShapelessRecipe removeIngredient(@NotNull Material ingredient)
                    // ShapelessRecipe removeIngredient(@NotNull MaterialData ingredient)
                    TODO()
                }
                .function("removeIngredient", 2) {
                    // ShapelessRecipe removeIngredient(int count, @NotNull Material ingredient)
                    // ShapelessRecipe removeIngredient(int count, @NotNull MaterialData ingredient)
                    // ShapelessRecipe removeIngredient(@NotNull Material ingredient, int rawdata)
                    TODO()
                }
                .function("removeIngredient", 3) {
                    it.target?.removeIngredient(
                        it.getNumber(0).toInt(),
                        it.getArgument(1) as Material,
                        it.getNumber(2).toInt()
                    )
                }
                .function("ingredientList", 0) { it.target?.ingredientList }
                .function("choiceList", 0) { it.target?.choiceList }
        }
    }
}
