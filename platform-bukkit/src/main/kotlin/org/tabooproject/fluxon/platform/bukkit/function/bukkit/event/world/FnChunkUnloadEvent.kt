package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.ChunkUnloadEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.world.ChunkUnloadEvent"])
@PlatformSide(Platform.BUKKIT)
object FnChunkUnloadEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkUnloadEvent::class.java)
                .function("isSaveChunk", returns(Type.Z).noParams()) { it.target?.isSaveChunk }
                .function("setSaveChunk", returnsObject().params(Type.OBJECT)) { it.target?.setSaveChunk(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { ChunkUnloadEvent.getHandlerList() }
        }
    }
}
