package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerExpCooldownChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerExpCooldownChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerExpCooldownChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerExpCooldownChangeEvent::class.java)
                .function("reason", returnsObject().noParams()) { it.target?.reason }
                .function("newCooldown", returnsObject().noParams()) { it.target?.newCooldown }
                .function("setNewCooldown", returnsObject().params(Type.OBJECT)) { it.target?.setNewCooldown(it.getInt(0).toInt()) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerExpCooldownChangeEvent.getHandlerList() }
        }
    }
}
