package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.AsyncStructureSpawnEvent
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

@Requires(classes = ["org.bukkit.event.world.AsyncStructureSpawnEvent"])
@PlatformSide(Platform.BUKKIT)
object FnAsyncStructureSpawnEvent {

    val TYPE = Type.fromClass(AsyncStructureSpawnEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AsyncStructureSpawnEvent::class.java)
                .function("structure",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure.FnStructure.TYPE).noParams()) { it.setReturnRef(it.target?.structure) }
                .function("boundingBox",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).noParams()) { it.setReturnRef(it.target?.boundingBox) }
                .function("chunkX",returns(Type.I).noParams()) { it.setReturnRef(it.target?.chunkX) }
                .function("chunkZ",returns(Type.I).noParams()) { it.setReturnRef(it.target?.chunkZ) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(AsyncStructureSpawnEvent.getHandlerList()) }
        }
    }
}
