package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.PluginCommandYamlParser
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.command.PluginCommandYamlParser"])
@PlatformSide(Platform.BUKKIT)
object FnPluginCommandYamlParser {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginCommandYamlParser::class.java)
                .function("parse", returnsObject().params(Type.OBJECT)) { PluginCommandYamlParser.parse(it.getRef(0) as Plugin) }
        }
    }
}
