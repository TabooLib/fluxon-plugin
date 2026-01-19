package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Raid
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnRaid {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Raid::class.java)
                .function("isStarted", 0) { it.target?.isStarted }
                .function("activeTicks", 0) { it.target?.activeTicks }
                .function("badOmenLevel", 0) { it.target?.badOmenLevel }
                .function("setBadOmenLevel", 1) { it.target?.setBadOmenLevel(it.getNumber(0).toInt()) }
                .function("location", 0) { it.target?.location }
                .function("status", 0) { it.target?.status }
                .function("spawnedGroups", 0) { it.target?.spawnedGroups }
                .function("totalGroups", 0) { it.target?.totalGroups }
                .function("totalWaves", 0) { it.target?.totalWaves }
                .function("totalHealth", 0) { it.target?.totalHealth }
                .function("heroes", 0) { it.target?.heroes }
                .function("raiders", 0) { it.target?.raiders }
        }
    }
}
