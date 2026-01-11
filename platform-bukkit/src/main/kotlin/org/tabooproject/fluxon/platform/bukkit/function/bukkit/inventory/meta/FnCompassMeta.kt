package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.Location
import org.bukkit.inventory.meta.CompassMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCompassMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CompassMeta::class.java)
                .function("hasLodestone", 0) { it.target?.hasLodestone() }
                .function("lodestone", 0) { it.target?.lodestone }
                .function("setLodestone", 1) { it.target?.setLodestone(it.getArgument(0) as Location) }
                .function("isLodestoneTracked", 0) { it.target?.isLodestoneTracked }
                .function("setLodestoneTracked", 1) { it.target?.setLodestoneTracked(it.getBoolean(0)) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
