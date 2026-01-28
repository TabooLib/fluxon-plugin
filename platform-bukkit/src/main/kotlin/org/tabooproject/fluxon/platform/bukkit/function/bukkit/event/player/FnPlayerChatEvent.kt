package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerChatEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerChatEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerChatEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerChatEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("message", returnsObject().noParams()) { it.target?.message }
                .function("setMessage", returnsObject().params(Type.OBJECT)) { it.target?.setMessage(it.getString(0)!!) }
                .function("setPlayer", returnsObject().params(Type.OBJECT)) { it.target?.setPlayer(it.getRef(0) as Player) }
                .function("format", returnsObject().noParams()) { it.target?.format }
                .function("setFormat", returnsObject().params(Type.OBJECT)) { it.target?.setFormat(it.getString(0)!!) }
                .function("recipients", returnsObject().noParams()) { it.target?.recipients }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerChatEvent.getHandlerList() }
        }
    }
}
