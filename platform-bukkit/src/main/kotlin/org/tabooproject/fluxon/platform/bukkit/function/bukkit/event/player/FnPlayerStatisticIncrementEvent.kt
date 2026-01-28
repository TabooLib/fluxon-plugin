package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerStatisticIncrementEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerStatisticIncrementEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerStatisticIncrementEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerStatisticIncrementEvent::class.java)
                .function("statistic", returnsObject().noParams()) { it.target?.getStatistic() }
                .function("previousValue", returnsObject().noParams()) { it.target?.previousValue }
                .function("newValue", returnsObject().noParams()) { it.target?.newValue }
                .function("entityType", returnsObject().noParams()) { it.target?.entityType }
                .function("material", returnsObject().noParams()) { it.target?.material }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { PlayerStatisticIncrementEvent.getHandlerList() }
        }
    }
}
