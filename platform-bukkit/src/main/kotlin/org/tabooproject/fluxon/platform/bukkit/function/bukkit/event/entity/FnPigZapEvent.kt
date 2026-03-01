package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.PigZapEvent
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

@Requires(classes = ["org.bukkit.event.entity.PigZapEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPigZapEvent {

    val TYPE = Type.fromClass(PigZapEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PigZapEvent::class.java)
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("lightning",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLightningStrike.TYPE).noParams()) { it.setReturnRef(it.target?.lightning) }
                .function("pigZombie",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPigZombie.TYPE).noParams()) { it.setReturnRef(it.target?.pigZombie) }
                .function("handlers", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PigZapEvent.getHandlerList()) }
        }
    }
}
