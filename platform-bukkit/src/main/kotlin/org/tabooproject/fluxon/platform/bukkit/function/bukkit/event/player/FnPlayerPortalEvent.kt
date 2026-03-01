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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.event.player.PlayerPortalEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerPortalEvent {

    val TYPE = Type.fromClass(PlayerPortalEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerPortalEvent::class.java)
                .function("setSearchRadius", returnsVoid().params(Type.I)) { it.target?.setSearchRadius(it.getInt(0).toInt()) }
                .function("searchRadius",returns(Type.I).noParams()) { it.setReturnRef(it.target?.searchRadius) }
                .function("canCreatePortal", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canCreatePortal ?: false) }
                .function("setCanCreatePortal", returnsVoid().params(Type.Z)) { it.target?.setCanCreatePortal(it.getBool(0)) }
                .function("setCreationRadius", returnsVoid().params(Type.I)) { it.target?.setCreationRadius(it.getInt(0).toInt()) }
                .function("creationRadius",returns(Type.I).noParams()) { it.setReturnRef(it.target?.creationRadius) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerPortalEvent.getHandlerList()) }
        }
    }
}
