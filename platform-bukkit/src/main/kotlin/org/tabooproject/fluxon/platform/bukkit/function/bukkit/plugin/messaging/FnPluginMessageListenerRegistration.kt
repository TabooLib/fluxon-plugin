package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.plugin.messaging.PluginMessageListenerRegistration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPluginMessageListenerRegistration {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginMessageListenerRegistration::class.java)
                .function("channel", 0) { it.target?.channel }
                .function("listener", 0) { it.target?.listener }
                .function("plugin", 0) { it.target?.plugin }
                .function("isValid", 0) { it.target?.isValid }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("hashCode", 0) { it.target?.hashCode() }
        }
    }
}
