package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPlaceEvent
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

@Requires(classes = ["org.bukkit.event.block.BlockPlaceEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPlaceEvent {

    val TYPE = Type.fromClass(BlockPlaceEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPlaceEvent::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("player", returnsObject().noParams()) { it.setReturnRef(it.target?.getPlayer()) }
                .function("blockPlaced", returnsObject().noParams()) { it.setReturnRef(it.target?.blockPlaced) }
                .function("blockReplacedState", returnsObject().noParams()) { it.setReturnRef(it.target?.blockReplacedState) }
                .function("blockAgainst", returnsObject().noParams()) { it.setReturnRef(it.target?.blockAgainst) }
                .function("itemInHand", returnsObject().noParams()) { it.setReturnRef(it.target?.getItemInHand()) }
                .function("hand", returnsObject().noParams()) { it.setReturnRef(it.target?.getHand()) }
                .function("canBuild", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canBuild() ?: false) }
                .function("setBuild", returnsVoid().params(Type.Z)) { it.target?.setBuild(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(BlockPlaceEvent.getHandlerList()) }
        }
    }
}
