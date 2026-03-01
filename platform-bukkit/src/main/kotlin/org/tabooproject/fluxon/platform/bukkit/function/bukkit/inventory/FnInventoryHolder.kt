package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.InventoryHolder
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.InventoryHolder"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryHolder {

    val TYPE = Type.fromClass(InventoryHolder::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryHolder::class.java)
                .function("inventory",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
