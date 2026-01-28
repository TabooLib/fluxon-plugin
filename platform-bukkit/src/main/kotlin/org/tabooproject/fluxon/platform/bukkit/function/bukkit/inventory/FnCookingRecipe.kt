package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.CookingRecipe
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.recipe.CookingBookCategory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.CookingRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnCookingRecipe {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CookingRecipe::class.java)
                .function("setInput", returnsObject().params(Type.OBJECT)) { it.target?.setInput(it.getRef(0) as Material) }
                .function("input", returnsObject().noParams()) { it.target?.input }
                .function("setInputChoice", returnsObject().params(Type.OBJECT)) { it.target?.setInputChoice(it.getRef(0) as RecipeChoice) }
                .function("inputChoice", returnsObject().noParams()) { it.target?.inputChoice }
                .function("result", returnsObject().noParams()) { it.target?.result }
                .function("setExperience", returnsObject().params(Type.OBJECT)) { it.target?.setExperience(it.getFloat(0)) }
                .function("experience", returnsObject().noParams()) { it.target?.experience }
                .function("setCookingTime", returnsObject().params(Type.OBJECT)) { it.target?.setCookingTime(it.getInt(0).toInt()) }
                .function("cookingTime", returnsObject().noParams()) { it.target?.cookingTime }
                .function("key", returnsObject().noParams()) { it.target?.key }
                .function("group", returnsObject().noParams()) { it.target?.group }
                .function("setGroup", returnsObject().params(Type.OBJECT)) { it.target?.setGroup(it.getString(0)!!) }
                .function("category", returnsObject().noParams()) { it.target?.category }
                .function("setCategory", returnsObject().params(Type.OBJECT)) { it.target?.setCategory(it.getRef(0) as CookingBookCategory) }
        }
    }
}
