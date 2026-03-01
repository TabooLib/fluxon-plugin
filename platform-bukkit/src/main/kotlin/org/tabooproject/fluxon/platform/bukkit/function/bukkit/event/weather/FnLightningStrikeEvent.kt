package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.weather

import org.bukkit.event.weather.LightningStrikeEvent
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

@Requires(classes = ["org.bukkit.event.weather.LightningStrikeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnLightningStrikeEvent {

    val TYPE = Type.fromClass(LightningStrikeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LightningStrikeEvent::class.java)
                .function("lightning",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLightningStrike.TYPE).noParams()) { it.setReturnRef(it.target?.lightning) }
                .function("cause", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.weather.FnLightningStrikeEventCause.TYPE).noParams()) { it.setReturnRef(it.target?.cause) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(LightningStrikeEvent.getHandlerList()) }
        }
    }
}
