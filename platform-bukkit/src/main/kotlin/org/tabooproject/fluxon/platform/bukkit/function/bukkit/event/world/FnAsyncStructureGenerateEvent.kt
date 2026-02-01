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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.world.AsyncStructureGenerateEvent"])
@PlatformSide(Platform.BUKKIT)
object FnAsyncStructureGenerateEvent {

    val TYPE = Type.fromClass(AsyncStructureGenerateEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AsyncStructureGenerateEvent::class.java)
                .function("cause", returnsObject().noParams()) { it.setReturnRef(it.target?.cause) }
                .function("getBlockTransformer", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getBlockTransformer(it.getRef(0) as NamespacedKey)) }
                .function("setBlockTransformer", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setBlockTransformer(
                        it.getRef(0) as NamespacedKey,
                        it.getRef(1) as BlockTransformer
                    )
                }
                .function("removeBlockTransformer", returnsVoid().params(Type.OBJECT)) { it.target?.removeBlockTransformer(it.getRef(0) as NamespacedKey) }
                .function("clearBlockTransformers", returnsVoid().noParams()) { it.target?.clearBlockTransformers() }
                .function("getEntityTransformer", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getEntityTransformer(it.getRef(0) as NamespacedKey)) }
                .function("setEntityTransformer", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setEntityTransformer(
                        it.getRef(0) as NamespacedKey,
                        it.getRef(1) as EntityTransformer
                    )
                }
                .function("removeEntityTransformer", returnsVoid().params(Type.OBJECT)) { it.target?.removeEntityTransformer(it.getRef(0) as NamespacedKey) }
                .function("clearEntityTransformers", returnsVoid().noParams()) { it.target?.clearEntityTransformers() }
                .function("structure", returnsObject().noParams()) { it.setReturnRef(it.target?.structure) }
                .function("boundingBox", returnsObject().noParams()) { it.setReturnRef(it.target?.boundingBox) }
                .function("chunkX", returns(Type.I).noParams()) { it.setReturnInt(it.target?.chunkX ?: 0) }
                .function("chunkZ", returns(Type.I).noParams()) { it.setReturnInt(it.target?.chunkZ ?: 0) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(AsyncStructureGenerateEvent.getHandlerList()) }
        }
    }
}
