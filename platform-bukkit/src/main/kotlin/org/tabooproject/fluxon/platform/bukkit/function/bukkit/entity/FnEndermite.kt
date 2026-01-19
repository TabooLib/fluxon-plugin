package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Endermite
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEndermite {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Endermite::class.java)
                .function("isPlayerSpawned", 0) { it.target?.isPlayerSpawned }
                .function("setPlayerSpawned", 1) { it.target?.setPlayerSpawned(it.getBoolean(0)) }
        }
    }
}
