package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.PluginCommandYamlParser
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.command.PluginCommandYamlParser"])
@PlatformSide(Platform.BUKKIT)
object FnPluginCommandYamlParser {

    val TYPE = Type.fromClass(PluginCommandYamlParser::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginCommandYamlParser::class.java)
                .function("parse",returns(Type.LIST).params(FnPlugin.TYPE)) { it.setReturnRef(PluginCommandYamlParser.parse(it.getRef(0) as Plugin)) }
        }
    }
}
