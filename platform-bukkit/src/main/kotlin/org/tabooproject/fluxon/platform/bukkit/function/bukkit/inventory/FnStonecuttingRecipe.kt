package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.RecipeChoice
import org.bukkit.inventory.StonecuttingRecipe
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

@Requires(classes = ["org.bukkit.inventory.StonecuttingRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnStonecuttingRecipe {

    val TYPE = Type.fromClass(StonecuttingRecipe::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StonecuttingRecipe::class.java)
                .function("setInput",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnStonecuttingRecipe.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(it.target?.setInput(it.getRef(0) as Material)) }
                .function("input",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.input) }
                .function("setInputChoice",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnStonecuttingRecipe.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipeChoice.TYPE)) { it.setReturnRef(it.target?.setInputChoice(it.getRef(0) as RecipeChoice)) }
                .function("inputChoice",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipeChoice.TYPE).noParams()) { it.setReturnRef(it.target?.inputChoice) }
                .function("result",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.result) }
                .function("key",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
                .function("group", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.group) }
                .function("setGroup", returnsVoid().params(Type.STRING)) { it.target?.setGroup(it.getString(0)!!) }
        }
    }
}
