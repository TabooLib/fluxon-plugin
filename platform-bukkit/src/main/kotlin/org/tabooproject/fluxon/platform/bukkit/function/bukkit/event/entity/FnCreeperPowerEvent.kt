package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.CreeperPowerEvent
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

@Requires(classes = ["org.bukkit.event.entity.CreeperPowerEvent"])
@PlatformSide(Platform.BUKKIT)
object FnCreeperPowerEvent {

    val TYPE = Type.fromClass(CreeperPowerEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CreeperPowerEvent::class.java)
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("lightning",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLightningStrike.TYPE).noParams()) { it.setReturnRef(it.target?.lightning) }
                .function("cause", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity.FnCreeperPowerEventPowerCause.TYPE).noParams()) { it.setReturnRef(it.target?.cause) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(CreeperPowerEvent.getHandlerList()) }
        }
    }
}
