package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.RecipeChoice
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.RecipeChoice"])
@PlatformSide(Platform.BUKKIT)
object FnRecipeChoice {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RecipeChoice::class.java)
                .function("itemStack", returnsObject().noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("test", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.test(it.getRef(0) as ItemStack)) }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.RecipeChoice.MaterialChoice"])
@PlatformSide(Platform.BUKKIT)
object FnRecipeChoiceMaterialChoice {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RecipeChoice.MaterialChoice::class.java)
                .function("itemStack", returnsObject().noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("test", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.test(it.getRef(0) as ItemStack)) }
                .function("choices", returnsObject().noParams()) { it.setReturnRef(it.target?.choices) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.RecipeChoice.ExactChoice"])
@PlatformSide(Platform.BUKKIT)
object FnRecipeChoiceExactChoice {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RecipeChoice.ExactChoice::class.java)
                .function("itemStack", returnsObject().noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("test", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.test(it.getRef(0) as ItemStack)) }
                .function("choices", returnsObject().noParams()) { it.setReturnRef(it.target?.choices) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
