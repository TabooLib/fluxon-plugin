package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Container
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Container"])
@PlatformSide(Platform.BUKKIT)
object FnContainer {

    val TYPE = Type.fromClass(Container::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Container::class.java)
                .function("inventory", returns(FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returns(FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
        }
    }
}
