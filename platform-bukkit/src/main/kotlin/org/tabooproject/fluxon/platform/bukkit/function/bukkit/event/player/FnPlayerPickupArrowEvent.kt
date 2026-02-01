package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerPickupArrowEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerPickupArrowEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerPickupArrowEvent {

    val TYPE = Type.fromClass(PlayerPickupArrowEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerPickupArrowEvent::class.java)
                .function("arrow", returnsObject().noParams()) { it.setReturnRef(it.target?.arrow) }
        }
    }
}
