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

@Requires(classes = ["org.bukkit.configuration.MemoryConfigurationOptions"])
@PlatformSide(Platform.BUKKIT)
object FnMemoryConfigurationOptions {

    val TYPE = Type.fromClass(org.bukkit.configuration.MemoryConfigurationOptions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.configuration.MemoryConfigurationOptions::class.java)
                .function("configuration", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnMemoryConfiguration.TYPE).noParams()) { it.setReturnRef(it.target?.configuration()) }
                .function("copyDefaults", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnMemoryConfigurationOptions.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.copyDefaults(it.getBool(0))) }
                .function("pathSeparator", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnMemoryConfigurationOptions.TYPE).params(Type.I)) { it.setReturnRef(it.target?.pathSeparator(it.getInt(0).toInt().toChar())) }
        }
    }
}
