package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.messaging.Messenger
import org.bukkit.plugin.messaging.PluginMessageListener
import org.bukkit.plugin.messaging.StandardMessenger
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.messaging.StandardMessenger"])
@PlatformSide(Platform.BUKKIT)
object FnStandardMessenger {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StandardMessenger::class.java)
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
                        else -> error("StandardMessenger#unregisterIncomingPluginChannel 函数参数数量错误: ${"args"}")
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
                        else -> error("StandardMessenger#unregisterIncomingPluginChannel 函数参数数量错误: ${"args"}")
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
                        else -> error("StandardMessenger#unregisterIncomingPluginChannel 函数参数数量错误: ${"args"}")
                    })
                }
                .function("dispatchIncomingMessage", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.dispatchIncomingMessage(
                        it.getRef(0) as Player,
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray
                    ))
                }
                // static
                .function("validateChannel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(StandardMessenger.validateChannel(it.getString(0)!!)) }
                // static
                .function("validateAndCorrectChannel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(StandardMessenger.validateAndCorrectChannel(it.getString(0)!!)) }
                // static
                .function("validatePluginMessage", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(StandardMessenger.validatePluginMessage(
                        it.getRef(0) as Messenger,
                        it.getRef(1) as Plugin,
                        it.getString(2)!!,
                        it.getRef(3) as ByteArray
                    ))
                }
        }
    }
}
