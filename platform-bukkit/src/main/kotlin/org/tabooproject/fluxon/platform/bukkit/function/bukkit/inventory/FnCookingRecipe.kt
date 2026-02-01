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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.CookingRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnCookingRecipe {

    val TYPE = Type.fromClass(CookingRecipe::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CookingRecipe::class.java)
                .function("setInput", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setInput(it.getRef(0) as Material)) }
                .function("input", returnsObject().noParams()) { it.setReturnRef(it.target?.input) }
                .function("setInputChoice", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setInputChoice(it.getRef(0) as RecipeChoice)) }
                .function("inputChoice", returnsObject().noParams()) { it.setReturnRef(it.target?.inputChoice) }
                .function("result", returnsObject().noParams()) { it.setReturnRef(it.target?.result) }
                .function("setExperience", returnsVoid().params(Type.F)) { it.target?.setExperience(it.getFloat(0)) }
                .function("experience", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.experience ?: 0f) }
                .function("setCookingTime", returnsVoid().params(Type.I)) { it.target?.setCookingTime(it.getInt(0)) }
                .function("cookingTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.cookingTime ?: 0) }
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                .function("group", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.group) }
                .function("setGroup", returnsVoid().params(Type.STRING)) { it.target?.setGroup(it.getString(0)!!) }
                .function("category", returnsObject().noParams()) { it.setReturnRef(it.target?.category) }
                .function("setCategory", returnsVoid().params(Type.OBJECT)) { it.target?.setCategory(it.getRef(0) as CookingBookCategory) }
        }
    }
}
