package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.CraftingInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.CraftingInventory"])
@PlatformSide(Platform.BUKKIT)
object FnCraftingInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CraftingInventory::class.java)
                .function("result", returnsObject().noParams()) { it.target?.result }
                .function("matrix", returnsObject().noParams()) { it.target?.matrix }
                .function("setResult", returnsObject().params(Type.OBJECT)) { it.target?.setResult(it.getRef(0) as ItemStack) }
                .function("setMatrix", returnsObject().params(Type.OBJECT)) { it.target?.setMatrix(it.getRef(0) as Array<ItemStack>) }
                .function("recipe", returnsObject().noParams()) { it.target?.recipe }
        }
    }
}
