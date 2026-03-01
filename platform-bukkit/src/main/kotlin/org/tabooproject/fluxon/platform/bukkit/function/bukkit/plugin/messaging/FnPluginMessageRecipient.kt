package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.messaging.PluginMessageRecipient
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.plugin.messaging.PluginMessageRecipient"])
@PlatformSide(Platform.BUKKIT)
object FnPluginMessageRecipient {

    val TYPE = Type.fromClass(PluginMessageRecipient::class.java)
    private val BYTE_ARRAY = Type.fromClass(ByteArray::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginMessageRecipient::class.java)
                .function("sendPluginMessage", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING, BYTE_ARRAY)) {
                    it.target?.sendPluginMessage(
                        it.getRef(0) as Plugin,
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray
                    )
                }
                .function("listeningPluginChannels", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.listeningPluginChannels) }
        }
    }
}
