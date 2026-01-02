package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.Bukkit
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FunctionBukkit {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("bukkit", 0) { Bukkit.getServer() }
            registerFunction("server", 0) { Bukkit.getServer() }
            registerFunction("broadcast", 1) {
                Bukkit.broadcastMessage(it.getArgument(0).toString())
            }
        }
    }
}