package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.StonecuttingRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnStonecuttingRecipe {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StonecuttingRecipe::class.java)
                .function("setInput", 1) { it.target?.setInput(it.getArgument(0) as Material) }
                .function("input", 0) { it.target?.input }
                .function("setInputChoice", 1) { it.target?.setInputChoice(it.getArgument(0) as RecipeChoice) }
                .function("inputChoice", 0) { it.target?.inputChoice }
                .function("result", 0) { it.target?.result }
                .function("key", 0) { it.target?.key }
                .function("group", 0) { it.target?.group }
                .function("setGroup", 1) { it.target?.setGroup(it.getString(0)!!) }
        }
    }
}
