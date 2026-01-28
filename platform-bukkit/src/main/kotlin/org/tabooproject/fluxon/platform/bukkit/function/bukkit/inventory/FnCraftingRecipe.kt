package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.CraftingRecipe
import org.bukkit.inventory.recipe.CraftingBookCategory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.CraftingRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnCraftingRecipe {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CraftingRecipe::class.java)
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                .function("result", returnsObject().noParams()) { it.setReturnRef(it.target?.result) }
                .function("group", returnsObject().noParams()) { it.setReturnRef(it.target?.group) }
                .function("setGroup", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setGroup(it.getString(0)!!)) }
                .function("category", returnsObject().noParams()) { it.setReturnRef(it.target?.category) }
                .function("setCategory", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCategory(it.getRef(0) as CraftingBookCategory)) }
        }
    }
}
