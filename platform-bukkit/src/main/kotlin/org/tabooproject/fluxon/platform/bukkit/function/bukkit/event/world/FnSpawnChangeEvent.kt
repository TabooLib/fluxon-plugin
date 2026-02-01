package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.SpawnChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.world.SpawnChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnChangeEvent {

    val TYPE = Type.fromClass(SpawnChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnChangeEvent::class.java)
                .function("previousLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.previousLocation) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(SpawnChangeEvent.getHandlerList()) }
        }
    }
}
