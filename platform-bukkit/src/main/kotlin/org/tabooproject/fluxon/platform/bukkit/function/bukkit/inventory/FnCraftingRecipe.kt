package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.CraftingRecipe
import org.bukkit.inventory.recipe.CraftingBookCategory
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

@Requires(classes = ["org.bukkit.inventory.CraftingRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnCraftingRecipe {

    val TYPE = Type.fromClass(CraftingRecipe::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CraftingRecipe::class.java)
                .function("key",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
                .function("result",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.result) }
                .function("group", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.group) }
                .function("setGroup", returnsVoid().params(Type.STRING)) { it.target?.setGroup(it.getString(0)!!) }
                .function("category", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.recipe.FnCraftingBookCategory.TYPE).noParams()) { it.setReturnRef(it.target?.category) }
                .function("setCategory", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.recipe.FnCraftingBookCategory.TYPE)) { it.target?.setCategory(it.getRef(0) as CraftingBookCategory)  }
                .function("setCategory", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.recipe.FnCraftingBookCategory.enumValue(it.getString(0))?.let { p0 -> it.target?.setCategory(p0)  } }
        }
    }
}
