package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.configuration.file.YamlConfigurationOptions"])
@PlatformSide(Platform.BUKKIT)
object FnYamlConfigurationOptions {

    val TYPE = Type.fromClass(org.bukkit.configuration.file.YamlConfigurationOptions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.configuration.file.YamlConfigurationOptions::class.java)
                .function("configuration", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfiguration.TYPE).noParams()) { it.setReturnRef(it.target?.configuration()) }
                .function("copyDefaults", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.copyDefaults(it.getBool(0))) }
                .function("pathSeparator", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.I)) { it.setReturnRef(it.target?.pathSeparator(it.getInt(0).toInt().toChar())) }
                // .function("setHeader", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.LIST)) { it.setReturnRef(it.target?.setHeader(it.getRef(0) as java.util.List)) }
                .function("header", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.header(it.getString(0))) }
                // .function("setFooter", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.LIST)) { it.setReturnRef(it.target?.setFooter(it.getRef(0) as java.util.List)) }
                .function("parseComments", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.parseComments(it.getBool(0))) }
                .function("copyHeader", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.copyHeader(it.getBool(0))) }
                .function("indent", returns(Type.I).noParams()) { it.setReturnInt(it.target?.indent() ?: 0) }
                .function("indent", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.I)) { it.setReturnRef(it.target?.indent(it.getInt(0).toInt())) }
                .function("width", returns(Type.I).noParams()) { it.setReturnInt(it.target?.width() ?: 0) }
                .function("width", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.I)) { it.setReturnRef(it.target?.width(it.getInt(0).toInt())) }
                // .function("codePointLimit", returns(Type.I).noParams()) { it.setReturnInt(it.target?.codePointLimit() ?: 0) }
                // .function("codePointLimit", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfigurationOptions.TYPE).params(Type.I)) { it.setReturnRef(it.target?.codePointLimit(it.getInt(0).toInt())) }
        }
    }
}
