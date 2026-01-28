package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.entity.EntityType
import org.bukkit.event.player.PlayerEggThrowEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerEggThrowEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerEggThrowEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerEggThrowEvent::class.java)
                .function("egg", returnsObject().noParams()) { it.setReturnRef(it.target?.egg) }
                .function("isHatching", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isHatching) }
                .function("setHatching", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHatching(it.getBool(0))) }
                .function("hatchingType", returnsObject().noParams()) { it.setReturnRef(it.target?.hatchingType) }
                .function("setHatchingType", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHatchingType(it.getRef(0) as EntityType)) }
                .function("numHatches", returnsObject().noParams()) { it.setReturnRef(it.target?.numHatches) }
                .function("setNumHatches", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setNumHatches(it.getInt(0).toByte())) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerEggThrowEvent.getHandlerList()) }
        }
    }
}
