package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.CraftItemEvent
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

@Requires(classes = ["org.bukkit.event.inventory.CraftItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnCraftItemEvent {

    val TYPE = Type.fromClass(CraftItemEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CraftItemEvent::class.java)
                .function("recipe", returns(FnRecipe.TYPE).noParams()) { it.setReturnRef(it.target?.recipe) }
                .function("inventory", returns(FnCraftingInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
