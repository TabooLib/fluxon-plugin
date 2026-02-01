package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerLocaleChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerLocaleChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerLocaleChangeEvent {

    val TYPE = Type.fromClass(PlayerLocaleChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerLocaleChangeEvent::class.java)
                .function("locale", returnsObject().noParams()) { it.setReturnRef(it.target?.locale) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerLocaleChangeEvent.getHandlerList()) }
        }
    }
}
