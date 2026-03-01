package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.RecipeChoice"])
@PlatformSide(Platform.BUKKIT)
object FnRecipeChoice {

    val TYPE = Type.fromClass(RecipeChoice::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RecipeChoice::class.java)
                .function("itemStack",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipeChoice.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("test",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.setReturnBool(it.target?.test(it.getRef(0) as ItemStack) ?: false)
                }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.RecipeChoice\$MaterialChoice"])
@PlatformSide(Platform.BUKKIT)
object FnRecipeChoiceMaterialChoice {

    val TYPE = Type.fromClass(RecipeChoice.MaterialChoice::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RecipeChoice.MaterialChoice::class.java)
                .function("itemStack", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("test",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.setReturnBool(it.target?.test(it.getRef(0) as ItemStack) ?: false)
                }
                .function("choices", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.choices) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.RecipeChoice\$ExactChoice"])
@PlatformSide(Platform.BUKKIT)
object FnRecipeChoiceExactChoice {

    val TYPE = Type.fromClass(RecipeChoice.ExactChoice::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RecipeChoice.ExactChoice::class.java)
                .function("itemStack", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("test",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.setReturnBool(it.target?.test(it.getRef(0) as ItemStack) ?: false)
                }
                .function("choices", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.choices) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
