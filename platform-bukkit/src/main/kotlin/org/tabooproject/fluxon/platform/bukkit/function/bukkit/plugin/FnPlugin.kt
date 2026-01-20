package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlugin {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Plugin::class.java)
                .function("dataFolder", 0) { it.target?.dataFolder }
                .function("description", 0) { it.target?.description }
                .function("config", 0) { it.target?.config }
                .function("resource", 1) { it.target?.getResource(it.getString(0)!!) }
                .function("saveConfig", 0) { it.target?.saveConfig() }
                .function("saveDefaultConfig", 0) { it.target?.saveDefaultConfig() }
                .function("saveResource", 2) { it.target?.saveResource(it.getString(0)!!, it.getBoolean(1)) }
                .function("reloadConfig", 0) { it.target?.reloadConfig() }
                .function("pluginLoader", 0) { it.target?.pluginLoader }
                .function("server", 0) { it.target?.server }
                .function("isEnabled", 0) { it.target?.isEnabled }
                .function("onDisable", 0) { it.target?.onDisable() }
                .function("onLoad", 0) { it.target?.onLoad() }
                .function("onEnable", 0) { it.target?.onEnable() }
                .function("isNaggable", 0) { it.target?.isNaggable }
                .function("setNaggable", 1) { it.target?.setNaggable(it.getBoolean(0)) }
                .function("defaultWorldGenerator", 2) {
                    it.target?.getDefaultWorldGenerator(
                        it.getString(0)!!,
                        it.getString(1)
                    )
                }
                .function("defaultBiomeProvider", 2) {
                    it.target?.getDefaultBiomeProvider(
                        it.getString(0)!!,
                        it.getString(1)
                    )
                }
                .function("logger", 0) { it.target?.logger }
                .function("name", 0) { it.target?.name }
        }
    }
}
