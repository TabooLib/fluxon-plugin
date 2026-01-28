package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPlaceEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.block.BlockPlaceEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPlaceEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPlaceEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("player", returnsObject().noParams()) { it.target?.getPlayer() }
                .function("blockPlaced", returnsObject().noParams()) { it.target?.blockPlaced }
                .function("blockReplacedState", returnsObject().noParams()) { it.target?.blockReplacedState }
                .function("blockAgainst", returnsObject().noParams()) { it.target?.blockAgainst }
                .function("itemInHand", returnsObject().noParams()) { it.target?.getItemInHand() }
                .function("hand", returnsObject().noParams()) { it.target?.getHand() }
                .function("canBuild", returns(Type.Z).noParams()) { it.target?.canBuild() }
                .function("setBuild", returnsObject().params(Type.OBJECT)) { it.target?.setBuild(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { BlockPlaceEvent.getHandlerList() }
        }
    }
}
