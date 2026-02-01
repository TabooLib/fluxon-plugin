package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.ChunkUnloadEvent
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

@Requires(classes = ["org.bukkit.event.world.ChunkUnloadEvent"])
@PlatformSide(Platform.BUKKIT)
object FnChunkUnloadEvent {

    val TYPE = Type.fromClass(ChunkUnloadEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkUnloadEvent::class.java)
                .function("isSaveChunk", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSaveChunk ?: false) }
                .function("setSaveChunk", returnsVoid().params(Type.Z)) { it.target?.setSaveChunk(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(ChunkUnloadEvent.getHandlerList()) }
        }
    }
}
