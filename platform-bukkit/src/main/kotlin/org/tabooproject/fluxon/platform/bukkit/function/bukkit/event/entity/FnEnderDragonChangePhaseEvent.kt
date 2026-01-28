package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.EnderDragon
import org.bukkit.event.entity.EnderDragonChangePhaseEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.EnderDragonChangePhaseEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEnderDragonChangePhaseEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderDragonChangePhaseEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.target?.getEntity() }
                .function("setNewPhase", returnsObject().params(Type.OBJECT)) { it.target?.setNewPhase(it.getRef(0) as EnderDragon.Phase) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { EnderDragonChangePhaseEvent.getHandlerList() }
        }
    }
}
