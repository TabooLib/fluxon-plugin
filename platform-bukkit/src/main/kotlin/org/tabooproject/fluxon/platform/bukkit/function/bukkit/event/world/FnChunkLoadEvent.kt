package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.ChunkLoadEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.world.ChunkLoadEvent"])
@PlatformSide(Platform.BUKKIT)
object FnChunkLoadEvent {

    val TYPE = Type.fromClass(ChunkLoadEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChunkLoadEvent::class.java)
                .function("isNewChunk", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isNewChunk ?: false) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(ChunkLoadEvent.getHandlerList()) }
        }
    }
}
