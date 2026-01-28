package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.messaging.PluginMessageRecipient
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.plugin.messaging.PluginMessageRecipient"])
@PlatformSide(Platform.BUKKIT)
object FnPluginMessageRecipient {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginMessageRecipient::class.java)
                .function("sendPluginMessage", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.sendPluginMessage(
                        it.getRef(0) as Plugin,
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray
                    ))
                }
                .function("listeningPluginChannels", returnsObject().noParams()) { it.setReturnRef(it.target?.listeningPluginChannels) }
        }
    }
}
