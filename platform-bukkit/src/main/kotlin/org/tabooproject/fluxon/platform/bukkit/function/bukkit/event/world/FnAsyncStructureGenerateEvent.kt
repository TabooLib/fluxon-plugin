package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.NamespacedKey
import org.bukkit.event.world.AsyncStructureGenerateEvent
import org.bukkit.util.BlockTransformer
import org.bukkit.util.EntityTransformer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAsyncStructureGenerateEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AsyncStructureGenerateEvent::class.java)
                .function("cause", 0) { it.target?.cause }
                .function("blockTransformer", 1) { it.target?.getBlockTransformer(it.getArgument(0) as NamespacedKey) }
                .function("setBlockTransformer", 2) {
                    it.target?.setBlockTransformer(
                        it.getArgument(0) as NamespacedKey,
                        it.getArgument(1) as BlockTransformer
                    )
                }
                .function(
                    "removeBlockTransformer",
                    1
                ) { it.target?.removeBlockTransformer(it.getArgument(0) as NamespacedKey) }
                .function("clearBlockTransformers", 0) { it.target?.clearBlockTransformers() }
                .function(
                    "entityTransformer",
                    1
                ) { it.target?.getEntityTransformer(it.getArgument(0) as NamespacedKey) }
                .function(
                    "setEntityTransformer",
                    2
                ) {
                    it.target?.setEntityTransformer(
                        it.getArgument(0) as NamespacedKey,
                        it.getArgument(1) as EntityTransformer
                    )
                }
                .function(
                    "removeEntityTransformer",
                    1
                ) { it.target?.removeEntityTransformer(it.getArgument(0) as NamespacedKey) }
                .function("clearEntityTransformers", 0) { it.target?.clearEntityTransformers() }
                .function("structure", 0) { it.target?.structure }
                .function("boundingBox", 0) { it.target?.boundingBox }
                .function("chunkX", 0) { it.target?.chunkX }
                .function("chunkZ", 0) { it.target?.chunkZ }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { AsyncStructureGenerateEvent.getHandlerList() }
        }
    }
}
