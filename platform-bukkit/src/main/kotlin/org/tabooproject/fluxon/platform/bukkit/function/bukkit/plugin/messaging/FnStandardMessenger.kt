package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.messaging.Messenger
import org.bukkit.plugin.messaging.PluginMessageListener
import org.bukkit.plugin.messaging.StandardMessenger
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnStandardMessenger {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StandardMessenger::class.java)
                .function("isReservedChannel", 1) { it.target?.isReservedChannel(it.getString(0)!!) }
                .function("registerOutgoingPluginChannel", 2) {
                    it.target?.registerOutgoingPluginChannel(
                        it.getArgument(
                            0
                        ) as Plugin, it.getString(1)!!
                    )
                }
                .function(
                    "unregisterOutgoingPluginChannel",
                    2
                ) { it.target?.unregisterOutgoingPluginChannel(it.getArgument(0) as Plugin, it.getString(1)!!) }
                .function(
                    "unregisterOutgoingPluginChannel",
                    1
                ) { it.target?.unregisterOutgoingPluginChannel(it.getArgument(0) as Plugin) }
                .function("registerIncomingPluginChannel", 3) {
                    it.target?.registerIncomingPluginChannel(
                        it.getArgument(
                            0
                        ) as Plugin, it.getString(1)!!, it.getArgument(2) as PluginMessageListener
                    )
                }
                .function(
                    "unregisterIncomingPluginChannel",
                    3
                ) {
                    it.target?.unregisterIncomingPluginChannel(
                        it.getArgument(0) as Plugin,
                        it.getString(1)!!,
                        it.getArgument(2) as PluginMessageListener
                    )
                }
                .function(
                    "unregisterIncomingPluginChannel",
                    2
                ) { it.target?.unregisterIncomingPluginChannel(it.getArgument(0) as Plugin, it.getString(1)!!) }
                .function(
                    "unregisterIncomingPluginChannel",
                    1
                ) { it.target?.unregisterIncomingPluginChannel(it.getArgument(0) as Plugin) }
                .function(
                    "dispatchIncomingMessage",
                    3
                ) {
                    it.target?.dispatchIncomingMessage(
                        it.getArgument(0) as Player,
                        it.getString(1)!!,
                        it.getArgument(2) as ByteArray
                    )
                }
                // static
                .function("validateChannel", 1) { StandardMessenger.validateChannel(it.getString(0)!!) }
                // static
                .function(
                    "validateAndCorrectChannel",
                    1
                ) { StandardMessenger.validateAndCorrectChannel(it.getString(0)!!) }
                // static
                .function(
                    "validatePluginMessage",
                    4
                ) {
                    StandardMessenger.validatePluginMessage(
                        it.getArgument(0) as Messenger,
                        it.getArgument(1) as Plugin,
                        it.getString(2)!!,
                        it.getArgument(3) as ByteArray
                    )
                }
        }
    }
}
