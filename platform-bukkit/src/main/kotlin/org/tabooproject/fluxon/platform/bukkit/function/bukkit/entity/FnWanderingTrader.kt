package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.WanderingTrader
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWanderingTrader {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WanderingTrader::class.java)
                .function("despawnDelay", 0) { it.target?.despawnDelay }
                .function("setDespawnDelay", 1) { it.target?.setDespawnDelay(it.getNumber(0).toInt()) }
        }
    }
}
