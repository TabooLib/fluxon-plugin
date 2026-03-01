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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.messaging.Messenger"])
@PlatformSide(Platform.BUKKIT)
object FnMessenger {

    val TYPE = Type.fromClass(Messenger::class.java)
    private val BYTE_ARRAY = Type.fromClass(ByteArray::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Messenger::class.java)
                .function("isReservedChannel", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.isReservedChannel(it.getString(0)!!) ?: false)
                }
                .function("registerOutgoingPluginChannel",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING)) {
                    it.target?.registerOutgoingPluginChannel(
                        it.getRef(
                            0
                        ) as Plugin, it.getString(1)!!
                    )
                }
                .function("unregisterOutgoingPluginChannel",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.target?.unregisterOutgoingPluginChannel(it.getRef(0) as Plugin)
                }
                .function("unregisterOutgoingPluginChannel",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING)) {
                    it.target?.unregisterOutgoingPluginChannel(it.getRef(0) as Plugin, it.getString(1)!!)
                }
                .function("registerIncomingPluginChannel",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging.FnPluginMessageListener.TYPE)) {
                    it.target?.registerIncomingPluginChannel(
                        it.getRef(
                            0
                        ) as Plugin, it.getString(1)!!, it.getRef(2) as PluginMessageListener
                    )
                }
                .function("unregisterIncomingPluginChannel",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin)
                }
                .function("unregisterIncomingPluginChannel",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING)) {
                    it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin, it.getString(1)!!)
                }
                .function("unregisterIncomingPluginChannel",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging.FnPluginMessageListener.TYPE)) {
                    it.target?.unregisterIncomingPluginChannel(
                        it.getRef(0) as Plugin,
                        it.getString(1)!!,
                        it.getRef(2) as PluginMessageListener
                    )
                }
                .function("outgoingChannels", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.outgoingChannels) }
                .function("getOutgoingChannels", returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.setReturnRef(it.target?.getOutgoingChannels(it.getRef(0) as Plugin))
                }
                .function("incomingChannels", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.incomingChannels) }
                .function("getIncomingChannels", returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.setReturnRef(it.target?.getIncomingChannels(it.getRef(0) as Plugin))
                }
                .function("getIncomingChannelRegistrations", returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.setReturnRef(it.target?.getIncomingChannelRegistrations(it.getRef(0) as Plugin))
                }
                .function("getIncomingChannelRegistrations", returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(Type.STRING)) {
                    it.setReturnRef(it.target?.getIncomingChannelRegistrations(it.getString(0)!!))
                }
                .function("getIncomingChannelRegistrations", returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING)) {
                    it.setReturnRef(it.target?.getIncomingChannelRegistrations(it.getRef(0) as Plugin, it.getString(1)!!))
                }
                .function("isRegistrationValid",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging.FnPluginMessageListenerRegistration.TYPE)) {
                    it.setReturnBool(it.target?.isRegistrationValid(it.getRef(0) as PluginMessageListenerRegistration) ?: false)
                }
                .function("isIncomingChannelRegistered",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING)) {
                    it.setReturnBool(it.target?.isIncomingChannelRegistered(it.getRef(0) as Plugin, it.getString(1)!!) ?: false)
                }
                .function("isOutgoingChannelRegistered",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING)) {
                    it.setReturnBool(it.target?.isOutgoingChannelRegistered(it.getRef(0) as Plugin, it.getString(1)!!) ?: false)
                }
                .function("dispatchIncomingMessage", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE, Type.STRING, BYTE_ARRAY)) {
                    it.target?.dispatchIncomingMessage(
                        it.getRef(0) as Player,
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray
                    )
                }
        }
    }
}
