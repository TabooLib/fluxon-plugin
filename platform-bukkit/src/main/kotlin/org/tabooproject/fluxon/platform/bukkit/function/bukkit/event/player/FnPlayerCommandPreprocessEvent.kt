package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerCommandPreprocessEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerCommandPreprocessEvent {

    val TYPE = Type.fromClass(PlayerCommandPreprocessEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerCommandPreprocessEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("message", returnsObject().noParams()) { it.setReturnRef(it.target?.message) }
                .function("setMessage", returnsVoid().params(Type.STRING)) { it.target?.setMessage(it.getString(0)!!) }
                .function("setPlayer", returnsVoid().params(Type.OBJECT)) { it.target?.setPlayer(it.getRef(0) as Player) }
                .function("recipients", returnsObject().noParams()) { it.setReturnRef(it.target?.recipients) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerCommandPreprocessEvent.getHandlerList()) }
        }
    }
}
