package org.tabooproject.fluxon.platform.bukkit.function.world

import org.bukkit.Bukkit
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.UUID

object FunctionWorld {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("world", 1) {
                when (val id = it.getArgument(0)) {
                    is UUID -> Bukkit.getWorld(id)
                    is String -> Bukkit.getWorld(id)
                    else -> null
                }
            }
            registerFunction("worlds", 0) { Bukkit.getWorlds() }
        }
    }
}