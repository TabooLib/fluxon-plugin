package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareAnvilEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnAnvilInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.PrepareAnvilEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPrepareAnvilEvent {

    val TYPE = Type.fromClass(PrepareAnvilEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareAnvilEvent::class.java)
                .function("inventory", returns(FnAnvilInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
