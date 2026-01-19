package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.messaging.PluginMessageRecipient
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPluginMessageRecipient {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginMessageRecipient::class.java)
                .function("sendPluginMessage", 3) {
                    it.target?.sendPluginMessage(
                        it.getArgument(0) as Plugin,
                        it.getString(1)!!,
                        it.getArgument(2) as ByteArray
                    )
                }
                .function("listeningPluginChannels", 0) { it.target?.listeningPluginChannels }
        }
    }
}
