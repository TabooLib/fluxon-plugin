package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.scoreboard.Criterias
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCriterias {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Criterias::class.java)
        }
    }
}
