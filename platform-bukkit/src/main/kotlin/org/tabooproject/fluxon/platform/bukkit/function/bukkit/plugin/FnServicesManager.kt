package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.ServicesManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnServicesManager {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServicesManager::class.java)
                .function("unregisterAll", 1) { it.target?.unregisterAll(it.getArgument(0) as Plugin) }
                .function("unregister", 1) {
                    // void unregister(@NotNull Class<?> var1, @NotNull Object var2)
                    // void unregister(@NotNull Object var1)
                    TODO()
                }
        }
    }
}
