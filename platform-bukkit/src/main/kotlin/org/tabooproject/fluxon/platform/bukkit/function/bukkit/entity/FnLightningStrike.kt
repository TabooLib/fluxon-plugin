package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LightningStrike
import org.bukkit.entity.Player
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnLightningStrike {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LightningStrike::class.java)
                .function("isEffect", 0) { it.target?.isEffect }
                .function("flashes", 0) { it.target?.flashes }
                .function("setFlashes", 1) { it.target?.setFlashes(it.getNumber(0).toInt()) }
                .function("lifeTicks", 0) { it.target?.lifeTicks }
                .function("setLifeTicks", 1) { it.target?.setLifeTicks(it.getNumber(0).toInt()) }
                .function("causingPlayer", 0) { it.target?.causingPlayer }
                .function("setCausingPlayer", 1) { it.target?.setCausingPlayer(it.getArgument(0) as Player) }
                .function("isSilent", 0) { it.target?.isSilent }
        }
    }
}
