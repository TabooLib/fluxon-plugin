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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerEggThrowEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerEggThrowEvent {

    val TYPE = Type.fromClass(PlayerEggThrowEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerEggThrowEvent::class.java)
                .function("egg", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEgg.TYPE).noParams()) { it.setReturnRef(it.target?.egg) }
                .function("isHatching", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isHatching ?: false) }
                .function("setHatching", returnsVoid().params(Type.Z)) { it.target?.setHatching(it.getBool(0)) }
                .function("hatchingType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE).noParams()) { it.setReturnRef(it.target?.hatchingType) }
                .function("setHatchingType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) { it.target?.setHatchingType(it.getRef(0) as EntityType) }
                .function("numHatches",returns(Type.I).noParams()) { it.setReturnRef(it.target?.numHatches) }
                .function("setNumHatches", returnsVoid().params(Type.I)) { it.target?.setNumHatches(it.getInt(0).toByte()) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerEggThrowEvent.getHandlerList()) }
        }
    }
}
