package org.tabooproject.fluxon.platform.bukkit.function.entity

import org.bukkit.Bukkit
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.platform.util.onlinePlayers
import java.util.UUID

object FunctionPlayer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("player", 1) {
                when (val id = it.getArgument(0)) {
                    is UUID -> Bukkit.getPlayer(id)
                    is String -> Bukkit.getPlayerExact(id)
                    else -> null
                }
            }
            registerFunction("players", 0) { onlinePlayers }
        }
    }
}