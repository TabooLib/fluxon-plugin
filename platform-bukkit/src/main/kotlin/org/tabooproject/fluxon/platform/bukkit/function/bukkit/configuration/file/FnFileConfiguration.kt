package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.bukkit.configuration.file.FileConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFileConfiguration {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FileConfiguration::class.java)
                .function("save", 1) { it.target?.save(it.getString(0)!!) }
                .function("saveToString", 0) { it.target?.saveToString() }
                .function("load", 1) {
                    // void load(@NotNull File file)
                    // void load(@NotNull String file)
                    TODO()
                }
                .function("loadFromString", 1) { it.target?.loadFromString(it.getString(0)!!) }
        }
    }
}
