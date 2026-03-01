package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.SmithingRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.SmithingRecipe"])
@PlatformSide(Platform.BUKKIT)
object FnSmithingRecipe {

    val TYPE = Type.fromClass(SmithingRecipe::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SmithingRecipe::class.java)
                .function("base",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipeChoice.TYPE).noParams()) { it.setReturnRef(it.target?.base) }
                .function("addition",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipeChoice.TYPE).noParams()) { it.setReturnRef(it.target?.addition) }
                .function("result",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.result) }
                .function("key",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
        }
    }
}
