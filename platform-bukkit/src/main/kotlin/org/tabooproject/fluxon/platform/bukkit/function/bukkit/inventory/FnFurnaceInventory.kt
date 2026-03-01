package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.FurnaceInventory
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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.FurnaceInventory"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceInventory {

    val TYPE = Type.fromClass(FurnaceInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceInventory::class.java)
                .function("result",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.result) }
                .function("fuel",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.fuel) }
                .function("smelting",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.smelting) }
                .function("setFuel",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setFuel(it.getRef(0) as ItemStack) }
                .function("setResult",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setResult(it.getRef(0) as ItemStack) }
                .function("setSmelting",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setSmelting(it.getRef(0) as ItemStack) }
                .function("holder",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnFurnace.TYPE).noParams()) { it.setReturnRef(it.target?.holder) }
        }
    }
}
