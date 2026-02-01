package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerJoinEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerJoinEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerJoinEvent {

    val TYPE = Type.fromClass(PlayerJoinEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerJoinEvent::class.java)
                .function("joinMessage", returnsObject().noParams()) { it.setReturnRef(it.target?.joinMessage) }
                .function("setJoinMessage", returnsVoid().params(Type.STRING)) { it.target?.setJoinMessage(it.getString(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerJoinEvent.getHandlerList()) }
        }
    }
}
