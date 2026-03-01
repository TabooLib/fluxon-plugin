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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.MerchantInventory"])
@PlatformSide(Platform.BUKKIT)
object FnMerchantInventory {

    val TYPE = Type.fromClass(MerchantInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MerchantInventory::class.java)
                .function("selectedRecipeIndex",returns(Type.I).noParams()) { it.setReturnRef(it.target?.selectedRecipeIndex) }
                .function("selectedRecipe",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnMerchantRecipe.TYPE).noParams()) { it.setReturnRef(it.target?.selectedRecipe) }
                .function("merchant",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnMerchant.TYPE).noParams()) { it.setReturnRef(it.target?.merchant) }
        }
    }
}
