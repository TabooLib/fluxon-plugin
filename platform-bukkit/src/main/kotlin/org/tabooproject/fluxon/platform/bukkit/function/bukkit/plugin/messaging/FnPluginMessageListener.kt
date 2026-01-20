package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.entity.Player
import org.bukkit.plugin.messaging.PluginMessageListener
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPluginMessageListener {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginMessageListener::class.java)
                .function("onPluginMessageReceived", 3) {
                    it.target?.onPluginMessageReceived(
                        it.getString(0)!!,
                        it.getArgument(1) as Player,
                        it.getArgument(2) as ByteArray
                    )
                }
        }
    }
}
