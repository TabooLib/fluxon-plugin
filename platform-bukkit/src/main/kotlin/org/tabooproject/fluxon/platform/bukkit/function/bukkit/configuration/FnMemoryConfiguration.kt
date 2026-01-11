package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.bukkit.configuration.Configuration
import org.bukkit.configuration.MemoryConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMemoryConfiguration {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MemoryConfiguration::class.java)
                .function("addDefault", 2) { it.target?.addDefault(it.getString(0)!!, it.getArgument(1)) }
                .function("addDefaults", 1) {
                    // void addDefaults(@NotNull Map<String, Object> defaults)
                    // void addDefaults(@NotNull Configuration defaults)
                    TODO()
                }
                .function("setDefaults", 1) { it.target?.setDefaults(it.getArgument(0) as Configuration) }
                .function("defaults", 0) { it.target?.getDefaults() }
                .function("parent", 0) { it.target?.parent }
        }
    }
}
