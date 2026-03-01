package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerStatisticIncrementEvent
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

@Requires(classes = ["org.bukkit.event.player.PlayerStatisticIncrementEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerStatisticIncrementEvent {

    val TYPE = Type.fromClass(PlayerStatisticIncrementEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerStatisticIncrementEvent::class.java)
                .function("statistic",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE).noParams()) { it.setReturnRef(it.target?.getStatistic()) }
                .function("previousValue",returns(Type.I).noParams()) { it.setReturnRef(it.target?.previousValue) }
                .function("newValue",returns(Type.I).noParams()) { it.setReturnRef(it.target?.newValue) }
                .function("entityType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE).noParams()) { it.setReturnRef(it.target?.entityType) }
                .function("material",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.material) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerStatisticIncrementEvent.getHandlerList()) }
        }
    }
}
