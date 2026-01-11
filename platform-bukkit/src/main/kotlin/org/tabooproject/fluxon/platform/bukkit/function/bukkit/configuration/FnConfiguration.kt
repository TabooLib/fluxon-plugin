package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.bukkit.configuration.Configuration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnConfiguration {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Configuration::class.java)
                .function("addDefault", 2) { it.target?.addDefault(it.getString(0)!!, it.getArgument(1)) }
                .function("addDefaults", 1) {
                    // void addDefaults(@NotNull Map<String, Object> var1)
                    // void addDefaults(@NotNull Configuration var1)
                    TODO()
                }
                .function("setDefaults", 1) { it.target?.setDefaults(it.getArgument(0) as Configuration) }
                .function("defaults", 0) { it.target?.defaults }
        }
    }
}
