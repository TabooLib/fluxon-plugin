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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.ShapelessRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnShapelessRecipe {

    val TYPE = Type.fromClass(ShapelessRecipe::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShapelessRecipe::class.java)
                .function("addIngredient", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE)) { it.setReturnRef(it.target?.addIngredient(it.getRef(0) as MaterialData)) }
                .function("addIngredient", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(it.target?.addIngredient(it.getRef(0) as Material)) }
                .function("addIngredient", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipeChoice.TYPE)) { it.setReturnRef(it.target?.addIngredient(it.getRef(0) as RecipeChoice)) }
                .function("addIngredient",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(Type.I, Type.I)) {
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
                .function("addIngredient",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) {
                    it.setReturnRef(it.target?.addIngredient(
                        it.getInt(0).toInt(),
                        it.getRef(1) as Material,
                        it.getInt(2).toInt()
                    ))
                }
                .function("removeIngredient",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipeChoice.TYPE)) { it.setReturnRef(it.target?.removeIngredient(it.getRef(0) as RecipeChoice)) }
                .function("removeIngredient",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(it.target?.removeIngredient(it.getRef(0) as Material)) }
                .function("removeIngredient",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE)) { it.setReturnRef(it.target?.removeIngredient(it.getRef(0) as MaterialData)) }
                .function("removeIngredient",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(Type.I, Type.I)) {
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
                .function("removeIngredient",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnShapelessRecipe.TYPE).params(Type.I, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) {
                    it.setReturnRef(it.target?.removeIngredient(
                        it.getInt(0).toInt(),
                        it.getRef(1) as Material,
                        it.getInt(2).toInt()
                    ))
                }
                .function("ingredientList",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.ingredientList) }
                .function("choiceList",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.choiceList) }
        }
    }
}
