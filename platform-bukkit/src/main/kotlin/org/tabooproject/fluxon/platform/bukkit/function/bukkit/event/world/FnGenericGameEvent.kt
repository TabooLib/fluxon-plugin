package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.GenericGameEvent
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

@Requires(classes = ["org.bukkit.event.world.GenericGameEvent"])
@PlatformSide(Platform.BUKKIT)
object FnGenericGameEvent {

    val TYPE = Type.fromClass(GenericGameEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GenericGameEvent::class.java)
                .function("event",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnGameEvent.TYPE).noParams()) { it.setReturnRef(it.target?.event) }
                .function("location",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
                .function("entity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entity) }
                .function("radius",returns(Type.I).noParams()) { it.setReturnRef(it.target?.radius) }
                .function("setRadius", returnsVoid().params(Type.I)) { it.target?.setRadius(it.getInt(0).toInt()) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(GenericGameEvent.getHandlerList()) }
        }
    }
}
