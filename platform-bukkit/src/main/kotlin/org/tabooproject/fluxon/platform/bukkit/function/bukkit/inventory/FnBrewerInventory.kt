package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.BrewerInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.BrewerInventory"])
@PlatformSide(Platform.BUKKIT)
object FnBrewerInventory {

    val TYPE = Type.fromClass(BrewerInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewerInventory::class.java)
                .function("ingredient", returnsObject().noParams()) { it.setReturnRef(it.target?.ingredient) }
                .function("setIngredient", returnsVoid().params(Type.OBJECT)) { it.target?.setIngredient(it.getRef(0) as ItemStack) }
                .function("fuel", returnsObject().noParams()) { it.setReturnRef(it.target?.fuel) }
                .function("setFuel", returnsVoid().params(Type.OBJECT)) { it.target?.setFuel(it.getRef(0) as ItemStack) }
                .function("holder", returnsObject().noParams()) { it.setReturnRef(it.target?.holder) }
        }
    }
}
