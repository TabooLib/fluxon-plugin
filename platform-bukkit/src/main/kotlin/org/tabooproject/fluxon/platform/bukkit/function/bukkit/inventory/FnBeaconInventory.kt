package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.BeaconInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.BeaconInventory"])
@PlatformSide(Platform.BUKKIT)
object FnBeaconInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BeaconInventory::class.java)
                .function("setItem", returnsObject().params(Type.OBJECT)) { it.target?.setItem(it.getRef(0) as ItemStack) }
                .function("item", returnsObject().noParams()) { it.target?.item }
        }
    }
}
