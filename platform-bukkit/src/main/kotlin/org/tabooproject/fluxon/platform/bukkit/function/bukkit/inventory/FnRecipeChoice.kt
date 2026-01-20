package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRecipeChoice {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RecipeChoice::class.java)
                .function("itemStack", 0) { it.target?.itemStack }
                .function("clone", 0) { it.target?.clone() }
                .function("test", 1) { it.target?.test(it.getArgument(0) as ItemStack) }

            registerExtension(RecipeChoice.MaterialChoice::class.java)
                .function("itemStack", 0) { it.target?.itemStack }
                .function("clone", 0) { it.target?.clone() }
                .function("test", 1) { it.target?.test(it.getArgument(0) as ItemStack) }
                .function("choices", 0) { it.target?.choices }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("toString", 0) { it.target?.toString() }

            registerExtension(RecipeChoice.ExactChoice::class.java)
                .function("itemStack", 0) { it.target?.itemStack }
                .function("clone", 0) { it.target?.clone() }
                .function("test", 1) { it.target?.test(it.getArgument(0) as ItemStack) }
                .function("choices", 0) { it.target?.choices }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
