package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.bukkit.configuration.Configuration
import org.bukkit.configuration.MemoryConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.configuration.MemoryConfiguration"])
@PlatformSide(Platform.BUKKIT)
object FnMemoryConfiguration {

    val TYPE = Type.fromClass(MemoryConfiguration::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MemoryConfiguration::class.java)
                .function("addDefault", returnsVoid().params(Type.STRING, Type.OBJECT)) { it.target?.addDefault(it.getString(0)!!, it.getRef(1)) }
                .function("addDefaults", returnsVoid().params(Type.MAP)) { it.target?.addDefaults(it.getRef(0) as Map<String, Any>) }
                .function("addDefaults", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnConfiguration.TYPE)) { it.target?.addDefaults(it.getRef(0) as Configuration) }
                .function("setDefaults",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnConfiguration.TYPE)) { it.target?.setDefaults(it.getRef(0) as Configuration) }
                .function("defaults",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnConfiguration.TYPE).noParams()) { it.setReturnRef(it.target?.getDefaults()) }
                .function("parent",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.FnConfigurationSection.TYPE).noParams()) { it.setReturnRef(it.target?.parent) }
        }
    }
}
