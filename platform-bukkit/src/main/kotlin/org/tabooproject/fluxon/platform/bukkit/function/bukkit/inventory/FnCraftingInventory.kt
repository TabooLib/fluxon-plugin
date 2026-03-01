package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.CraftingInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.CraftingInventory"])
@PlatformSide(Platform.BUKKIT)
object FnCraftingInventory {

    val TYPE = Type.fromClass(CraftingInventory::class.java)
    private val ITEM_STACK_ARRAY = Type.fromClass(Array<ItemStack>::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CraftingInventory::class.java)
                .function("result", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.result) }
                .function("matrix", returns(ITEM_STACK_ARRAY).noParams()) { it.setReturnRef(it.target?.matrix) }
                .function("setResult",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setResult(it.getRef(0) as ItemStack) }
                .function("setMatrix", returnsVoid().params(ITEM_STACK_ARRAY)) { it.target?.setMatrix(it.getRef(0) as Array<ItemStack>) }
                .function("recipe", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnRecipe.TYPE).noParams()) { it.setReturnRef(it.target?.recipe) }
        }
    }
}
