package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.DoubleChestInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.DoubleChestInventory"])
@PlatformSide(Platform.BUKKIT)
object FnDoubleChestInventory {

    val TYPE = Type.fromClass(DoubleChestInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DoubleChestInventory::class.java)
                .function("leftSide",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.leftSide) }
                .function("rightSide",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.rightSide) }
                .function("holder",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnDoubleChest.TYPE).noParams()) { it.setReturnRef(it.target?.holder) }
        }
    }
}
