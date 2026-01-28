package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.StructureGrowEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.world.StructureGrowEvent"])
@PlatformSide(Platform.BUKKIT)
object FnStructureGrowEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureGrowEvent::class.java)
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
                .function("species", returnsObject().noParams()) { it.setReturnRef(it.target?.species) }
                .function("isFromBonemeal", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isFromBonemeal) }
                .function("player", returnsObject().noParams()) { it.setReturnRef(it.target?.player) }
                .function("blocks", returnsObject().noParams()) { it.setReturnRef(it.target?.blocks) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCancelled(it.getBool(0))) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(StructureGrowEvent.getHandlerList()) }
        }
    }
}
