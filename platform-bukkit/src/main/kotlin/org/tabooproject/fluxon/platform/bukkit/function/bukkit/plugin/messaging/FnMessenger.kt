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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.messaging.Messenger"])
@PlatformSide(Platform.BUKKIT)
object FnMessenger {

    val TYPE = Type.fromClass(Messenger::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Messenger::class.java)
                .function("isReservedChannel", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.isReservedChannel(it.getString(0)!!) ?: false)
                }
                .function("registerOutgoingPluginChannel", returnsVoid().params(Type.OBJECT, Type.STRING)) {
                    it.target?.registerOutgoingPluginChannel(
                        it.getRef(
                            0
                        ) as Plugin, it.getString(1)!!
                    )
                }
                .function("unregisterOutgoingPluginChannel", returnsVoid().params(Type.OBJECT)) {
                    it.target?.unregisterOutgoingPluginChannel(it.getRef(0) as Plugin)
                }
                .function("unregisterOutgoingPluginChannel", returnsVoid().params(Type.OBJECT, Type.STRING)) {
                    it.target?.unregisterOutgoingPluginChannel(it.getRef(0) as Plugin, it.getString(1)!!)
                }
                .function("registerIncomingPluginChannel", returnsVoid().params(Type.OBJECT, Type.STRING, Type.OBJECT)) {
                    it.target?.registerIncomingPluginChannel(
                        it.getRef(
                            0
                        ) as Plugin, it.getString(1)!!, it.getRef(2) as PluginMessageListener
                    )
                }
                .function("unregisterIncomingPluginChannel", returnsVoid().params(Type.OBJECT)) {
                    it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin)
                }
                .function("unregisterIncomingPluginChannel", returnsVoid().params(Type.OBJECT, Type.STRING)) {
                    it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin, it.getString(1)!!)
                }
                .function("unregisterIncomingPluginChannel", returnsVoid().params(Type.OBJECT, Type.STRING, Type.OBJECT)) {
                    it.target?.unregisterIncomingPluginChannel(
                        it.getRef(0) as Plugin,
                        it.getString(1)!!,
                        it.getRef(2) as PluginMessageListener
                    )
                }
                .function("outgoingChannels", returnsObject().noParams()) { it.setReturnRef(it.target?.outgoingChannels) }
                .function("getOutgoingChannels", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getOutgoingChannels(it.getRef(0) as Plugin)) }
                .function("incomingChannels", returnsObject().noParams()) { it.setReturnRef(it.target?.incomingChannels) }
                .function("getIncomingChannels", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getIncomingChannels(it.getRef(0) as Plugin)) }
                .function("getIncomingChannelRegistrations", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Plugin -> it.target?.getIncomingChannelRegistrations(var1)
                        is String -> it.target?.getIncomingChannelRegistrations(var1)
                        else -> throw IllegalArgumentException("参数必须是 Plugin 或 String 类型")
                    })
                }
                .function("getIncomingChannelRegistrations", returnsObject().params(Type.OBJECT, Type.STRING)) {
                    it.setReturnRef(it.target?.getIncomingChannelRegistrations(it.getRef(0) as Plugin, it.getString(1)!!))
                }
                .function("isRegistrationValid", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.isRegistrationValid(it.getRef(0) as PluginMessageListenerRegistration) ?: false)
                }
                .function("isIncomingChannelRegistered", returns(Type.Z).params(Type.OBJECT, Type.STRING)) {
                    it.setReturnBool(it.target?.isIncomingChannelRegistered(it.getRef(0) as Plugin, it.getString(1)!!) ?: false)
                }
                .function("isOutgoingChannelRegistered", returns(Type.Z).params(Type.OBJECT, Type.STRING)) {
                    it.setReturnBool(it.target?.isOutgoingChannelRegistered(it.getRef(0) as Plugin, it.getString(1)!!) ?: false)
                }
                .function("dispatchIncomingMessage", returnsVoid().params(Type.OBJECT, Type.STRING, Type.OBJECT)) {
                    it.target?.dispatchIncomingMessage(
                        it.getRef(0) as Player,
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray
                    )
                }
        }
    }
}
