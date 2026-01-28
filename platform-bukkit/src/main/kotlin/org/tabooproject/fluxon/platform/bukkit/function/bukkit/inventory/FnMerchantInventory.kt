package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.MerchantInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.MerchantInventory"])
@PlatformSide(Platform.BUKKIT)
object FnMerchantInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MerchantInventory::class.java)
                .function("selectedRecipeIndex", returnsObject().noParams()) { it.target?.selectedRecipeIndex }
                .function("selectedRecipe", returnsObject().noParams()) { it.target?.selectedRecipe }
                .function("merchant", returnsObject().noParams()) { it.target?.merchant }
        }
    }
}
