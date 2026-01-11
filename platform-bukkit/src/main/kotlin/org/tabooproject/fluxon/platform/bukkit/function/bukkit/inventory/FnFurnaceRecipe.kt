package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.FurnaceRecipe
import org.bukkit.inventory.RecipeChoice
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFurnaceRecipe {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceRecipe::class.java)
                .function("setInput", 1) {
                    // FurnaceRecipe setInput(@NotNull MaterialData input)
                    // FurnaceRecipe setInput(@NotNull Material input)
                    TODO()
                }
                .function("setInput", 2) { it.target?.setInput(it.getArgument(0) as Material, it.getNumber(1).toInt()) }
                .function("setInputChoice", 1) { it.target?.setInputChoice(it.getArgument(0) as RecipeChoice) }
        }
    }
}
