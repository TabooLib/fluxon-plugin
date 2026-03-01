package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.Location
import org.bukkit.event.player.PlayerRespawnEvent
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

@Requires(classes = ["org.bukkit.event.player.PlayerRespawnEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerRespawnEvent {

    val TYPE = Type.fromClass(PlayerRespawnEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerRespawnEvent::class.java)
                .function("respawnLocation", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.respawnLocation) }
                .function("setRespawnLocation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.target?.setRespawnLocation(it.getRef(0) as Location) }
                .function("isBedSpawn", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBedSpawn ?: false) }
                .function("isAnchorSpawn", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAnchorSpawn ?: false) }
                .function("respawnReason", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player.FnPlayerRespawnEventRespawnReason.TYPE).noParams()) { it.setReturnRef(it.target?.respawnReason) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerRespawnEvent.getHandlerList()) }
        }
    }
}
