package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.CraftingRecipe
import org.bukkit.inventory.recipe.CraftingBookCategory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCraftingRecipe {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CraftingRecipe::class.java)
                .function("key", 0) { it.target?.key }
                .function("result", 0) { it.target?.result }
                .function("group", 0) { it.target?.group }
                .function("setGroup", 1) { it.target?.setGroup(it.getString(0)!!) }
                .function("category", 0) { it.target?.category }
                .function("setCategory", 1) { it.target?.setCategory(it.getArgument(0) as CraftingBookCategory) }
        }
    }
}
