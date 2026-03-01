package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.configuration.ConfigurationOptions"])
@PlatformSide(Platform.BUKKIT)
object FnConfigurationOptions {

    val TYPE = Type.fromClass(org.bukkit.configuration.ConfigurationOptions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.configuration.ConfigurationOptions::class.java)
                .function("configuration", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnConfiguration.TYPE).noParams()) { it.setReturnRef(it.target?.configuration()) }
                // .function("pathSeparator", returns(Type.I).noParams()) { it.setReturnInt(it.target?.pathSeparator() ?: 0) }
                .function("pathSeparator", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnConfigurationOptions.TYPE).params(Type.I)) { it.setReturnRef(it.target?.pathSeparator(it.getInt(0).toInt().toChar())) }
                .function("copyDefaults", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.copyDefaults() ?: false) }
                .function("copyDefaults", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnConfigurationOptions.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.copyDefaults(it.getBool(0))) }
        }
    }
}
