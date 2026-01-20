package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.bukkit.configuration.Configuration
import org.bukkit.configuration.MemoryConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMemoryConfiguration {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MemoryConfiguration::class.java)
                .function("addDefault", 2) { it.target?.addDefault(it.getString(0)!!, it.getArgument(1)) }
                .function("addDefaults", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Map<*, *> -> it.target?.addDefaults(var1 as Map<String, Any>)
                        is Configuration -> it.target?.addDefaults(var1)
                        else -> throw IllegalArgumentException("参数必须是 Map<String, Object> 或 Configuration 类型")
                    }
                }
                .function("setDefaults", 1) { it.target?.setDefaults(it.getArgument(0) as Configuration) }
                .function("defaults", 0) { it.target?.getDefaults() }
                .function("parent", 0) { it.target?.parent }
        }
    }
}
