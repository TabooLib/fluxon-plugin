package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerPortalEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerPortalEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerPortalEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerPortalEvent::class.java)
                .function("setSearchRadius", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSearchRadius(it.getInt(0).toInt())) }
                .function("searchRadius", returnsObject().noParams()) { it.setReturnRef(it.target?.searchRadius) }
                .function("canCreatePortal", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.canCreatePortal) }
                .function("setCanCreatePortal", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCanCreatePortal(it.getBool(0))) }
                .function("setCreationRadius", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCreationRadius(it.getInt(0).toInt())) }
                .function("creationRadius", returnsObject().noParams()) { it.setReturnRef(it.target?.creationRadius) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerPortalEvent.getHandlerList()) }
        }
    }
}
