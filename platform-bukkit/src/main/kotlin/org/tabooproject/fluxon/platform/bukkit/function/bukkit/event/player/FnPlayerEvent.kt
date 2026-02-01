package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.event.player.PlayerEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerEvent {

    val TYPE = Type.fromClass(PlayerEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerEvent::class.java)
                .function("player", returnsObject().noParams()) { it.setReturnRef(it.target?.getPlayer()) }
        }
    }
}
