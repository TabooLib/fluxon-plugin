package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.ProxiedCommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnProxiedCommandSender {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ProxiedCommandSender::class.java)
                .function("caller", 0) { it.target?.caller }
                .function("callee", 0) { it.target?.callee }
        }
    }
}
