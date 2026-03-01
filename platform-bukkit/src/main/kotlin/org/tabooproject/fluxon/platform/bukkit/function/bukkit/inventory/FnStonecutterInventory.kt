package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.StonecutterInventory"])
@PlatformSide(Platform.BUKKIT)
object FnStonecutterInventory {

    val TYPE = Type.fromClass(org.bukkit.inventory.StonecutterInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.inventory.StonecutterInventory::class.java)
                // .function("getInputItem", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.getInputItem()) }
                // .function("setInputItem", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setInputItem(it.getRef(0) as org.bukkit.inventory.ItemStack) }
                // .function("getResult", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.getResult()) }
                // .function("setResult", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setResult(it.getRef(0) as org.bukkit.inventory.ItemStack) }
        }
    }
}
