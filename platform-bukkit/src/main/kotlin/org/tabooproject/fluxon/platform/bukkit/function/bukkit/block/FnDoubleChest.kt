package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.DoubleChest
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryHolder
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.DoubleChest"])
@PlatformSide(Platform.BUKKIT)
object FnDoubleChest {

    val TYPE = Type.fromClass(DoubleChest::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DoubleChest::class.java)
                .function("inventory", returns(FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("leftSide", returns(FnInventoryHolder.TYPE).noParams()) { it.setReturnRef(it.target?.leftSide) }
                .function("rightSide", returns(FnInventoryHolder.TYPE).noParams()) { it.setReturnRef(it.target?.rightSide) }
                .function("location", returns(FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
                .function("world", returns(FnWorld.TYPE).noParams()) { it.setReturnRef(it.target?.world) }
                .function("x", returns(Type.D).noParams()) { it.setReturnRef(it.target?.x) }
                .function("y", returns(Type.D).noParams()) { it.setReturnRef(it.target?.y) }
                .function("z", returns(Type.D).noParams()) { it.setReturnRef(it.target?.z) }
        }
    }
}
