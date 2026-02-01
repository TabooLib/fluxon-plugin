package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.Location
import org.bukkit.event.player.PlayerSpawnChangeEvent
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

@Requires(classes = ["org.bukkit.event.player.PlayerSpawnChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerSpawnChangeEvent {

    val TYPE = Type.fromClass(PlayerSpawnChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerSpawnChangeEvent::class.java)
                .function("cause", returnsObject().noParams()) { it.setReturnRef(it.target?.cause) }
                .function("isForced", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isForced ?: false) }
                .function("setForced", returnsVoid().params(Type.Z)) { it.target?.setForced(it.getBool(0)) }
                .function("newSpawn", returnsObject().noParams()) { it.setReturnRef(it.target?.newSpawn) }
                .function("setNewSpawn", returnsVoid().params(Type.OBJECT)) { it.target?.setNewSpawn(it.getRef(0) as Location) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerSpawnChangeEvent.getHandlerList()) }
        }
    }
}
