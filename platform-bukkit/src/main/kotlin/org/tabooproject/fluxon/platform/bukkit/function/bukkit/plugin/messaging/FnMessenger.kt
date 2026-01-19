package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.messaging.Messenger
import org.bukkit.plugin.messaging.PluginMessageListener
import org.bukkit.plugin.messaging.PluginMessageListenerRegistration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMessenger {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Messenger::class.java)
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
                .function("outgoingChannels", 0) { it.target?.outgoingChannels }
                .function("outgoingChannels", 1) { it.target?.getOutgoingChannels(it.getArgument(0) as Plugin) }
                .function("incomingChannels", 0) { it.target?.incomingChannels }
                .function("incomingChannels", 1) { it.target?.getIncomingChannels(it.getArgument(0) as Plugin) }
                .function("incomingChannelRegistrations", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Plugin -> it.target?.getIncomingChannelRegistrations(var1)
                        is String -> it.target?.getIncomingChannelRegistrations(var1)
                        else -> throw IllegalArgumentException("参数必须是 Plugin 或 String 类型")
                    }
                }
                .function(
                    "incomingChannelRegistrations",
                    2
                ) { it.target?.getIncomingChannelRegistrations(it.getArgument(0) as Plugin, it.getString(1)!!) }
                .function(
                    "isRegistrationValid",
                    1
                ) { it.target?.isRegistrationValid(it.getArgument(0) as PluginMessageListenerRegistration) }
                .function(
                    "isIncomingChannelRegistered",
                    2
                ) { it.target?.isIncomingChannelRegistered(it.getArgument(0) as Plugin, it.getString(1)!!) }
                .function(
                    "isOutgoingChannelRegistered",
                    2
                ) { it.target?.isOutgoingChannelRegistered(it.getArgument(0) as Plugin, it.getString(1)!!) }
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
        }
    }
}
