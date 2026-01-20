package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnShapedRecipe {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShapedRecipe::class.java)
                .function("shape", 0) {
                    it.target?.shape
                }
                .function("setIngredient", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        when (val var2 = it.getArgument(1)) {
                            is MaterialData -> it.target?.setIngredient(it.getString(0)!!.first(), var2)
                            is Material -> it.target?.setIngredient(it.getString(0)!!.first(), var2)
                            is RecipeChoice -> it.target?.setIngredient(it.getString(0)!!.first(), var2)
                            else -> throw IllegalArgumentException("参数2必须是 MaterialData, Material, 或 RecipeChoice 类型")
                        }
                    } else {
                        it.target?.setIngredient(
                            it.getString(0)?.firstOrNull()!!,
                            it.getArgument(1) as Material,
                            it.getNumber(2).toInt()
                        )
                    }
                }
        }
    }
}
