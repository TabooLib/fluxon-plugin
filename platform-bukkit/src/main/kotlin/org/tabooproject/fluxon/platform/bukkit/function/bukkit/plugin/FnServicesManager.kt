package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.ServicesManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnServicesManager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServicesManager::class.java)
                .function("unregisterAll", 1) { it.target?.unregisterAll(it.getArgument(0) as Plugin) }
                .function("unregister", 1) {
                    it.target?.unregister(it.getArgument(0)!!)
                }
        }
    }
}
