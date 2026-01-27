package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.MerchantInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.inventory.MerchantInventory"])
@PlatformSide(Platform.BUKKIT)
object FnMerchantInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MerchantInventory::class.java)
                .function("selectedRecipeIndex", 0) { it.target?.selectedRecipeIndex }
                .function("selectedRecipe", 0) { it.target?.selectedRecipe }
                .function("merchant", 0) { it.target?.merchant }
        }
    }
}
