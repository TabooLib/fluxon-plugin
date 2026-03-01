package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.ExplosionPrimeEvent
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

@Requires(classes = ["org.bukkit.event.entity.ExplosionPrimeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnExplosionPrimeEvent {

    val TYPE = Type.fromClass(ExplosionPrimeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExplosionPrimeEvent::class.java)
                .function("radius", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.radius ?: 0f) }
                .function("setRadius", returnsVoid().params(Type.F)) { it.target?.setRadius(it.getFloat(0)) }
                .function("fire", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.fire ?: false) }
                .function("setFire", returnsVoid().params(Type.Z)) { it.target?.setFire(it.getBool(0)) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(ExplosionPrimeEvent.getHandlerList()) }
        }
    }
}
