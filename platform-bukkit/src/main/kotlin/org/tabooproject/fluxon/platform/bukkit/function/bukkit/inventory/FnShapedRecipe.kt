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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.ShapedRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnShapedRecipe {

    val TYPE = Type.fromClass(ShapedRecipe::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShapedRecipe::class.java)
                .function("shape", returns(org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY).noParams()) { it.setReturnRef(it.target?.shape) }
                .function("setIngredient", returns(TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE)) { it.setReturnRef(it.target?.setIngredient(it.getString(0)!!.first(), it.getRef(1) as MaterialData)) }
                .function("setIngredient", returns(TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(it.target?.setIngredient(it.getString(0)!!.first(), it.getRef(1) as Material)) }
                .function("setIngredient", returns(TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipeChoice.TYPE)) { it.setReturnRef(it.target?.setIngredient(it.getString(0)!!.first(), it.getRef(1) as RecipeChoice)) }
                .function("setIngredient", returns(TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) {
                    it.setReturnRef(it.target?.setIngredient(
                        it.getString(0)?.firstOrNull()!!,
                        it.getRef(1) as Material,
                        it.getInt(2).toInt()
                    ))
                }
        }
    }
}
