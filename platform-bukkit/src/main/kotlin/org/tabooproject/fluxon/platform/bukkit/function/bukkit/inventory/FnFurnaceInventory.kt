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
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.FurnaceInventory"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceInventory::class.java)
                .function("result", returnsObject().noParams()) { it.target?.result }
                .function("fuel", returnsObject().noParams()) { it.target?.fuel }
                .function("smelting", returnsObject().noParams()) { it.target?.smelting }
                .function("setFuel", returnsObject().params(Type.OBJECT)) { it.target?.setFuel(it.getRef(0) as ItemStack) }
                .function("setResult", returnsObject().params(Type.OBJECT)) { it.target?.setResult(it.getRef(0) as ItemStack) }
                .function("setSmelting", returnsObject().params(Type.OBJECT)) { it.target?.setSmelting(it.getRef(0) as ItemStack) }
                .function("holder", returnsObject().noParams()) { it.target?.holder }
        }
    }
}
