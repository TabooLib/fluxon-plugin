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

@Requires(classes = ["org.bukkit.configuration.file.FileConfigurationOptions"])
@PlatformSide(Platform.BUKKIT)
object FnFileConfigurationOptions {

    val TYPE = Type.fromClass(org.bukkit.configuration.file.FileConfigurationOptions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.configuration.file.FileConfigurationOptions::class.java)
                .function("configuration", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnFileConfiguration.TYPE).noParams()) { it.setReturnRef(it.target?.configuration()) }
                .function("copyDefaults", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnFileConfigurationOptions.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.copyDefaults(it.getBool(0))) }
                .function("pathSeparator", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnFileConfigurationOptions.TYPE).params(Type.I)) { it.setReturnRef(it.target?.pathSeparator(it.getInt(0).toInt().toChar())) }
                .function("getHeader", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.getHeader()) }
                .function("header", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.header()) }
                // .function("setHeader", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnFileConfigurationOptions.TYPE).params(Type.LIST)) { it.setReturnRef(it.target?.setHeader(it.getRef(0) as java.util.List)) }
                .function("header", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnFileConfigurationOptions.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.header(it.getString(0))) }
                .function("getFooter", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.getFooter()) }
                // .function("setFooter", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnFileConfigurationOptions.TYPE).params(Type.LIST)) { it.setReturnRef(it.target?.setFooter(it.getRef(0) as java.util.List)) }
                .function("parseComments", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.parseComments() ?: false) }
                .function("parseComments", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnMemoryConfigurationOptions.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.parseComments(it.getBool(0))) }
                .function("copyHeader", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.copyHeader() ?: false) }
                .function("copyHeader", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnFileConfigurationOptions.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.copyHeader(it.getBool(0))) }
        }
    }
}
