package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.RegisteredServiceProvider
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRegisteredServiceProvider {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RegisteredServiceProvider::class.java)
                .function("service", 0) { it.target?.getService() }
                .function("plugin", 0) { it.target?.plugin }
                .function("provider", 0) { it.target?.getProvider() }
                .function("priority", 0) { it.target?.priority }
                .function("compareTo", 1) { it.target?.compareTo(it.getArgument(0) as RegisteredServiceProvider<*>) }
        }
    }
}
