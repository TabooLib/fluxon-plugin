package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerShearEntityEvent
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

@Requires(classes = ["org.bukkit.event.player.PlayerShearEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerShearEntityEvent {

    val TYPE = Type.fromClass(PlayerShearEntityEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerShearEntityEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.entity) }
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("hand", returnsObject().noParams()) { it.setReturnRef(it.target?.hand) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerShearEntityEvent.getHandlerList()) }
        }
    }
}
