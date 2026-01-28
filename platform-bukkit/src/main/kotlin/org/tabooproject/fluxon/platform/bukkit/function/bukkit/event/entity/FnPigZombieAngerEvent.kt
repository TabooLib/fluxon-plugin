package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.PigZombieAngerEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.PigZombieAngerEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPigZombieAngerEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PigZombieAngerEvent::class.java)
                .function("target", returnsObject().noParams()) { it.target?.target }
                .function("newAnger", returnsObject().noParams()) { it.target?.newAnger }
                .function("setNewAnger", returnsObject().params(Type.OBJECT)) { it.target?.setNewAnger(it.getInt(0).toInt()) }
                .function("entity", returnsObject().noParams()) { it.target?.getEntity() }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PigZombieAngerEvent.getHandlerList() }
        }
    }
}
