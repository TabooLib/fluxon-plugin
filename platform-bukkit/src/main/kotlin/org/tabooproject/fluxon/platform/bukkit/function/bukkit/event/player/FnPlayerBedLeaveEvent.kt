package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerBedLeaveEvent
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

@Requires(classes = ["org.bukkit.event.player.PlayerBedLeaveEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerBedLeaveEvent {

    val TYPE = Type.fromClass(PlayerBedLeaveEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerBedLeaveEvent::class.java)
                .function("bed", returnsObject().noParams()) { it.setReturnRef(it.target?.bed) }
                .function("shouldSetSpawnLocation", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.shouldSetSpawnLocation() ?: false) }
                .function("setSpawnLocation", returnsVoid().params(Type.Z)) { it.target?.setSpawnLocation(it.getBool(0)) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerBedLeaveEvent.getHandlerList()) }
        }
    }
}
