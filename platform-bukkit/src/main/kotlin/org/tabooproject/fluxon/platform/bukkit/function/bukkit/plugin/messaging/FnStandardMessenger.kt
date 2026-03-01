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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.messaging.StandardMessenger"])
@PlatformSide(Platform.BUKKIT)
object FnStandardMessenger {

    val TYPE = Type.fromClass(StandardMessenger::class.java)
    private val BYTE_ARRAY = Type.fromClass(ByteArray::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StandardMessenger::class.java)
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
                .function("dispatchIncomingMessage", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE, Type.STRING, BYTE_ARRAY)) {
                    it.target?.dispatchIncomingMessage(
                        it.getRef(0) as Player,
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray
                    )
                }
                // static
                .function("validateChannel", returnsVoid().params(Type.STRING)) { StandardMessenger.validateChannel(it.getString(0)!!) }
                // static
                .function("validateAndCorrectChannel", returns(Type.STRING).params(Type.STRING)) {
                    it.setReturnRef(StandardMessenger.validateAndCorrectChannel(it.getString(0)!!))
                }
                // static
                .function("validatePluginMessage", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging.FnMessenger.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING, BYTE_ARRAY)) {
                    StandardMessenger.validatePluginMessage(
                        it.getRef(0) as Messenger,
                        it.getRef(1) as Plugin,
                        it.getString(2)!!,
                        it.getRef(3) as ByteArray
                    )
                }
        }
    }
}
