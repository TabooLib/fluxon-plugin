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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.messaging.Messenger"])
@PlatformSide(Platform.BUKKIT)
object FnMessenger {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Messenger::class.java)
                .function("isReservedChannel", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isReservedChannel(it.getString(0)!!)) }
                .function("registerOutgoingPluginChannel", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.registerOutgoingPluginChannel(
                        it.getRef(
                            0
                        ) as Plugin, it.getString(1)!!
                    ))
                }
                .function("unregisterOutgoingPluginChannel", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.unregisterOutgoingPluginChannel(it.getRef(0) as Plugin)
                    } else {
                        it.target?.unregisterOutgoingPluginChannel(it.getRef(0) as Plugin, it.getString(1)!!)
                    })
                }
                .function("unregisterOutgoingPluginChannel", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.unregisterOutgoingPluginChannel(it.getRef(0) as Plugin)
                    } else {
                        it.target?.unregisterOutgoingPluginChannel(it.getRef(0) as Plugin, it.getString(1)!!)
                    })
                }
                .function("registerIncomingPluginChannel", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.registerIncomingPluginChannel(
                        it.getRef(
                            0
                        ) as Plugin, it.getString(1)!!, it.getRef(2) as PluginMessageListener
                    ))
                }
                .function("unregisterIncomingPluginChannel", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin)
                        2 -> it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin, it.getString(1)!!)
                        3 -> it.target?.unregisterIncomingPluginChannel(
                            it.getRef(0) as Plugin,
                            it.getString(1)!!,
                            it.getRef(2) as PluginMessageListener
                        )
                        else -> error("Messenger#unregisterIncomingPluginChannel 函数参数数量错误: ${"args"}")
                    })
                }
                .function("unregisterIncomingPluginChannel", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin)
                        2 -> it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin, it.getString(1)!!)
                        3 -> it.target?.unregisterIncomingPluginChannel(
                            it.getRef(0) as Plugin,
                            it.getString(1)!!,
                            it.getRef(2) as PluginMessageListener
                        )
                        else -> error("Messenger#unregisterIncomingPluginChannel 函数参数数量错误: ${"args"}")
                    })
                }
                .function("unregisterIncomingPluginChannel", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin)
                        2 -> it.target?.unregisterIncomingPluginChannel(it.getRef(0) as Plugin, it.getString(1)!!)
                        3 -> it.target?.unregisterIncomingPluginChannel(
                            it.getRef(0) as Plugin,
                            it.getString(1)!!,
                            it.getRef(2) as PluginMessageListener
                        )
                        else -> error("Messenger#unregisterIncomingPluginChannel 函数参数数量错误: ${"args"}")
                    })
                }
                .function("outgoingChannels", returnsObject().noParams()) { it.setReturnRef(it.target?.outgoingChannels) }
                .function("getOutgoingChannels", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getOutgoingChannels(it.getRef(0) as Plugin)) }
                .function("incomingChannels", returnsObject().noParams()) { it.setReturnRef(it.target?.incomingChannels) }
                .function("getIncomingChannels", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getIncomingChannels(it.getRef(0) as Plugin)) }
                .function("getIncomingChannelRegistrations", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Plugin -> it.target?.getIncomingChannelRegistrations(var1)
                            is String -> it.target?.getIncomingChannelRegistrations(var1)
                            else -> throw IllegalArgumentException("参数必须是 Plugin 或 String 类型")
                        }
                    } else {
                        it.target?.getIncomingChannelRegistrations(it.getRef(0) as Plugin, it.getString(1)!!)
                    })
                }
                .function("getIncomingChannelRegistrations", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Plugin -> it.target?.getIncomingChannelRegistrations(var1)
                            is String -> it.target?.getIncomingChannelRegistrations(var1)
                            else -> throw IllegalArgumentException("参数必须是 Plugin 或 String 类型")
                        }
                    } else {
                        it.target?.getIncomingChannelRegistrations(it.getRef(0) as Plugin, it.getString(1)!!)
                    })
                }
                .function("isRegistrationValid", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isRegistrationValid(it.getRef(0) as PluginMessageListenerRegistration)) }
                .function("isIncomingChannelRegistered", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.isIncomingChannelRegistered(it.getRef(0) as Plugin, it.getString(1)!!)) }
                .function("isOutgoingChannelRegistered", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.isOutgoingChannelRegistered(it.getRef(0) as Plugin, it.getString(1)!!)) }
                .function("dispatchIncomingMessage", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.dispatchIncomingMessage(
                        it.getRef(0) as Player,
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray
                    ))
                }
        }
    }
}
