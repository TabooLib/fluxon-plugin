package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.CraftItemEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.inventory.CraftItemEvent"])
@PlatformSide(Platform.BUKKIT)
object FnCraftItemEvent {

    val TYPE = Type.fromClass(CraftItemEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CraftItemEvent::class.java)
                .function("recipe", returnsObject().noParams()) { it.setReturnRef(it.target?.recipe) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
