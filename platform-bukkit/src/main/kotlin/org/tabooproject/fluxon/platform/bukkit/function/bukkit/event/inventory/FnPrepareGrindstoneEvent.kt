package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareGrindstoneEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnGrindstoneInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.PrepareGrindstoneEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPrepareGrindstoneEvent {

    val TYPE = Type.fromClass(PrepareGrindstoneEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareGrindstoneEvent::class.java)
                .function("inventory", returns(FnGrindstoneInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
