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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.ShapelessRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnShapelessRecipe {

    val TYPE = Type.fromClass(ShapelessRecipe::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShapelessRecipe::class.java)
                .function("addIngredient", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is MaterialData -> it.target?.addIngredient(var1)
                        is Material -> it.target?.addIngredient(var1)
                        is RecipeChoice -> it.target?.addIngredient(var1)
                        else -> throw IllegalArgumentException("参数必须是 MaterialData, Material, 或 RecipeChoice 类型")
                    })
                }
                .function("addIngredient", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.addIngredient(var1, it.getInt(1).toInt())
                        is Int -> when (val var2 = it.getRef(1)) {
                            is MaterialData -> it.target?.addIngredient(var1, var2)
                            is Material -> it.target?.addIngredient(var1, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 MaterialData 或 Material 类型")
                        }

                        else -> throw IllegalArgumentException("参数 1 必须是 Material 或 Int 类型")
                    })
                }
                .function("addIngredient", returnsObject().params(Type.I, Type.OBJECT, Type.I)) {
                    it.setReturnRef(it.target?.addIngredient(
                        it.getInt(0).toInt(),
                        it.getRef(1) as Material,
                        it.getInt(2).toInt()
                    ))
                }
                .function("removeIngredient", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is RecipeChoice -> it.target?.removeIngredient(var1)
                        is Material -> it.target?.removeIngredient(var1)
                        is MaterialData -> it.target?.removeIngredient(var1)
                        else -> throw IllegalArgumentException("参数必须是 RecipeChoice, Material, 或 MaterialData 类型")
                    })
                }
                .function("removeIngredient", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Int -> when (val var2 = it.getRef(1)) {
                            is Material -> it.target?.removeIngredient(var1, var2)
                            is MaterialData -> it.target?.removeIngredient(var1, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 Material 或 MaterialData 类型")
                        }

                        is Material -> it.target?.removeIngredient(var1, it.getInt(1).toInt())
                        else -> throw IllegalArgumentException("参数 1 必须是 Int 或 Material 类型")
                    })
                }
                .function("removeIngredient", returnsObject().params(Type.I, Type.OBJECT, Type.I)) {
                    it.setReturnRef(it.target?.removeIngredient(
                        it.getInt(0).toInt(),
                        it.getRef(1) as Material,
                        it.getInt(2).toInt()
                    ))
                }
                .function("ingredientList", returnsObject().noParams()) { it.setReturnRef(it.target?.ingredientList) }
                .function("choiceList", returnsObject().noParams()) { it.setReturnRef(it.target?.choiceList) }
        }
    }
}
