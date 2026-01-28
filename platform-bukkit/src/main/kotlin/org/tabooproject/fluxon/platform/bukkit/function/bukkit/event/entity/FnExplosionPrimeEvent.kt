package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.ExplosionPrimeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.ExplosionPrimeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnExplosionPrimeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExplosionPrimeEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("radius", returnsObject().noParams()) { it.target?.radius }
                .function("setRadius", returnsObject().params(Type.OBJECT)) { it.target?.setRadius(it.getFloat(0)) }
                .function("fire", returnsObject().noParams()) { it.target?.fire }
                .function("setFire", returnsObject().params(Type.OBJECT)) { it.target?.setFire(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { ExplosionPrimeEvent.getHandlerList() }
        }
    }
}
