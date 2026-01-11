package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.bukkit.configuration.file.YamlConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnYamlConfiguration {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(YamlConfiguration::class.java)
                .function("saveToString", 0) { it.target?.saveToString() }
                .function("loadFromString", 1) { it.target?.loadFromString(it.getString(0)!!) }
                // static
                .function("loadConfiguration", 1) {
                    // static YamlConfiguration loadConfiguration(@NotNull File file)
                    // static YamlConfiguration loadConfiguration(@NotNull Reader reader)
                    TODO()
                }
        }
    }
}
