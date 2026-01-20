package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.messaging.Messenger
import org.bukkit.plugin.messaging.PluginMessageListener
import org.bukkit.plugin.messaging.PluginMessageListenerRegistration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
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
                .function("unregisterOutgoingPluginChannel", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.unregisterOutgoingPluginChannel(it.getArgument(0) as Plugin)
                    } else {
                        it.target?.unregisterOutgoingPluginChannel(it.getArgument(0) as Plugin, it.getString(1)!!)
                    }
                }
                .function("registerIncomingPluginChannel", 3) {
                    it.target?.registerIncomingPluginChannel(
                        it.getArgument(
                            0
                        ) as Plugin, it.getString(1)!!, it.getArgument(2) as PluginMessageListener
                    )
                }
                .function("unregisterIncomingPluginChannel", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> it.target?.unregisterIncomingPluginChannel(it.getArgument(0) as Plugin)
                        2 -> it.target?.unregisterIncomingPluginChannel(it.getArgument(0) as Plugin, it.getString(1)!!)
                        3 -> it.target?.unregisterIncomingPluginChannel(
                            it.getArgument(0) as Plugin,
                            it.getString(1)!!,
                            it.getArgument(2) as PluginMessageListener
                        )
                        else -> error("Messenger#unregisterIncomingPluginChannel 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("outgoingChannels", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.outgoingChannels
                    } else {
                        it.target?.getOutgoingChannels(it.getArgument(0) as Plugin)
                    }
                }
                .function("incomingChannels", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.incomingChannels
                    } else {
                        it.target?.getIncomingChannels(it.getArgument(0) as Plugin)
                    }
                }
                .function("incomingChannelRegistrations", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is Plugin -> it.target?.getIncomingChannelRegistrations(var1)
                            is String -> it.target?.getIncomingChannelRegistrations(var1)
                            else -> throw IllegalArgumentException("参数必须是 Plugin 或 String 类型")
                        }
                    } else {
                        it.target?.getIncomingChannelRegistrations(it.getArgument(0) as Plugin, it.getString(1)!!)
                    }
                }
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
