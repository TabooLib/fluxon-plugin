package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.ShapelessRecipe
import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnShapelessRecipe {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShapelessRecipe::class.java)
                .function("addIngredient", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> when (val var1 = it.getArgument(0)) {
                            is MaterialData -> it.target?.addIngredient(var1)
                            is Material -> it.target?.addIngredient(var1)
                            is RecipeChoice -> it.target?.addIngredient(var1)
                            else -> throw IllegalArgumentException("参数必须是 MaterialData, Material, 或 RecipeChoice 类型")
                        }

                        2 -> when (val var1 = it.getArgument(0)) {
                            is Material -> it.target?.addIngredient(var1, it.getNumber(1).toInt())
                            is Int -> when (val var2 = it.getArgument(1)) {
                                is MaterialData -> it.target?.addIngredient(var1, var2)
                                is Material -> it.target?.addIngredient(var1, var2)
                                else -> throw IllegalArgumentException("参数2必须是 MaterialData 或 Material 类型")
                            }

                            else -> throw IllegalArgumentException("参数1必须是 Material 或 Int 类型")
                        }

                        3 -> it.target?.addIngredient(
                            it.getNumber(0).toInt(),
                            it.getArgument(1) as Material,
                            it.getNumber(2).toInt()
                        )
                        else -> error("ShapelessRecipe#addIngredient 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("removeIngredient", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> when (val var1 = it.getArgument(0)) {
                            is RecipeChoice -> it.target?.removeIngredient(var1)
                            is Material -> it.target?.removeIngredient(var1)
                            is MaterialData -> it.target?.removeIngredient(var1)
                            else -> throw IllegalArgumentException("参数必须是 RecipeChoice, Material, 或 MaterialData 类型")
                        }

                        2 -> when (val var1 = it.getArgument(0)) {
                            is Int -> when (val var2 = it.getArgument(1)) {
                                is Material -> it.target?.removeIngredient(var1, var2)
                                is MaterialData -> it.target?.removeIngredient(var1, var2)
                                else -> throw IllegalArgumentException("参数2必须是 Material 或 MaterialData 类型")
                            }

                            is Material -> it.target?.removeIngredient(var1, it.getNumber(1).toInt())
                            else -> throw IllegalArgumentException("参数1必须是 Int 或 Material 类型")
                        }

                        3 -> it.target?.removeIngredient(
                            it.getNumber(0).toInt(),
                            it.getArgument(1) as Material,
                            it.getNumber(2).toInt()
                        )
                        else -> error("ShapelessRecipe#removeIngredient 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("ingredientList", 0) { it.target?.ingredientList }
                .function("choiceList", 0) { it.target?.choiceList }
        }
    }
}
