package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerExpCooldownChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.player.PlayerExpCooldownChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerExpCooldownChangeEvent {

    val TYPE = Type.fromClass(PlayerExpCooldownChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerExpCooldownChangeEvent::class.java)
                .function("reason", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerExpCooldownChangeEventChangeReason.TYPE).noParams()) { it.setReturnRef(it.target?.reason) }
                .function("newCooldown", returns(Type.I).noParams()) { it.setReturnInt(it.target?.newCooldown ?: 0) }
                .function("setNewCooldown", returnsVoid().params(Type.I)) { it.target?.setNewCooldown(it.getInt(0).toInt()) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerExpCooldownChangeEvent.getHandlerList()) }
        }
    }
}
