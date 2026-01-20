package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.CookingRecipe
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.recipe.CookingBookCategory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCookingRecipe {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CookingRecipe::class.java)
                .function("setInput", 1) { it.target?.setInput(it.getArgument(0) as Material) }
                .function("input", 0) { it.target?.input }
                .function("setInputChoice", 1) { it.target?.setInputChoice(it.getArgument(0) as RecipeChoice) }
                .function("inputChoice", 0) { it.target?.inputChoice }
                .function("result", 0) { it.target?.result }
                .function("setExperience", 1) { it.target?.setExperience(it.getNumber(0).toFloat()) }
                .function("experience", 0) { it.target?.experience }
                .function("setCookingTime", 1) { it.target?.setCookingTime(it.getNumber(0).toInt()) }
                .function("cookingTime", 0) { it.target?.cookingTime }
                .function("key", 0) { it.target?.key }
                .function("group", 0) { it.target?.group }
                .function("setGroup", 1) { it.target?.setGroup(it.getString(0)!!) }
                .function("category", 0) { it.target?.category }
                .function("setCategory", 1) { it.target?.setCategory(it.getArgument(0) as CookingBookCategory) }
        }
    }
}
