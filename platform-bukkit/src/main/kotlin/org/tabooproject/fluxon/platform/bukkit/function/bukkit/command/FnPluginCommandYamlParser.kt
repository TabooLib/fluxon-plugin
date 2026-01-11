package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.PluginCommandYamlParser
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPluginCommandYamlParser {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginCommandYamlParser::class.java)
                .function("parse", 1) { PluginCommandYamlParser.parse(it.getArgument(0) as Plugin) }
        }
    }
}
