package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.java

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnJavaPlugin {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(JavaPlugin::class.java)
                .function("dataFolder", 0) { it.target?.dataFolder }
                .function("pluginLoader", 0) { it.target?.pluginLoader }
                .function("server", 0) { it.target?.server }
                .function("isEnabled", 0) { it.target?.isEnabled }
                .function("description", 0) { it.target?.description }
                .function("config", 0) { it.target?.config }
                .function("reloadConfig", 0) { it.target?.reloadConfig() }
                .function("saveConfig", 0) { it.target?.saveConfig() }
                .function("saveDefaultConfig", 0) { it.target?.saveDefaultConfig() }
                .function("saveResource", 2) { it.target?.saveResource(it.getString(0)!!, it.getBoolean(1)) }
                .function("resource", 1) { it.target?.getResource(it.getString(0)!!) }
                .function("onCommand", 4) {
                    it.target?.onCommand(
                        it.getArgument(0) as CommandSender,
                        it.getArgument(1) as Command,
                        it.getString(2)!!,
                        it.getArgument(3) as Array<String>
                    )
                }
                .function("onTabComplete", 4) {
                    it.target?.onTabComplete(
                        it.getArgument(0) as CommandSender,
                        it.getArgument(1) as Command,
                        it.getString(2)!!,
                        it.getArgument(3) as Array<String>
                    )
                }
                .function("command", 1) { it.target?.getCommand(it.getString(0)!!) }
                .function("onLoad", 0) { it.target?.onLoad() }
                .function("onDisable", 0) { it.target?.onDisable() }
                .function("onEnable", 0) { it.target?.onEnable() }
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
                .function("isNaggable", 0) { it.target?.isNaggable }
                .function("setNaggable", 1) { it.target?.setNaggable(it.getBoolean(0)) }
                .function("logger", 0) { it.target?.logger }
                .function("toString", 0) { it.target?.toString() }
                // static
                .function("providingPlugin", 1) { JavaPlugin.getProvidingPlugin(it.getArgument(0) as Class<*>) }
        }
    }
}
