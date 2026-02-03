package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnCraftingInventory
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.PrepareItemCraftEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPrepareItemCraftEvent {

    val TYPE = Type.fromClass(PrepareItemCraftEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareItemCraftEvent::class.java)
                .function("recipe", returns(FnRecipe.TYPE).noParams()) { it.setReturnRef(it.target?.recipe) }
                .function("inventory", returns(FnCraftingInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("isRepair", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRepair ?: false) }
        }
    }
}
