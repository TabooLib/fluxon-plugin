package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.GenericGameEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.world.GenericGameEvent"])
@PlatformSide(Platform.BUKKIT)
object FnGenericGameEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GenericGameEvent::class.java)
                .function("event", returnsObject().noParams()) { it.setReturnRef(it.target?.event) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.entity) }
                .function("radius", returnsObject().noParams()) { it.setReturnRef(it.target?.radius) }
                .function("setRadius", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRadius(it.getInt(0).toInt())) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(GenericGameEvent.getHandlerList()) }
        }
    }
}
