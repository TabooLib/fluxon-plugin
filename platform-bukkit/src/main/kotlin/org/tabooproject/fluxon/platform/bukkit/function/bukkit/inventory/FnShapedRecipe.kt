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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.ShapedRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnShapedRecipe {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShapedRecipe::class.java)
                .function("shape", returnsObject().noParams()) {
                    it.target?.shape
                }
                .function("setIngredient", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        when (val var2 = it.getRef(1)) {
                            is MaterialData -> it.target?.setIngredient(it.getString(0)!!.first(), var2)
                            is Material -> it.target?.setIngredient(it.getString(0)!!.first(), var2)
                            is RecipeChoice -> it.target?.setIngredient(it.getString(0)!!.first(), var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 MaterialData, Material, 或 RecipeChoice 类型")
                        }
                    } else {
                        it.target?.setIngredient(
                            it.getString(0)?.firstOrNull()!!,
                            it.getRef(1) as Material,
                            it.getInt(2).toInt()
                        )
                    }
                }
                .function("setIngredient", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        when (val var2 = it.getRef(1)) {
                            is MaterialData -> it.target?.setIngredient(it.getString(0)!!.first(), var2)
                            is Material -> it.target?.setIngredient(it.getString(0)!!.first(), var2)
                            is RecipeChoice -> it.target?.setIngredient(it.getString(0)!!.first(), var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 MaterialData, Material, 或 RecipeChoice 类型")
                        }
                    } else {
                        it.target?.setIngredient(
                            it.getString(0)?.firstOrNull()!!,
                            it.getRef(1) as Material,
                            it.getInt(2).toInt()
                        )
                    }
                }
        }
    }
}
