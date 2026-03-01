package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.entity.Player
import org.bukkit.plugin.messaging.PluginMessageListener
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.plugin.messaging.PluginMessageListener"])
@PlatformSide(Platform.BUKKIT)
object FnPluginMessageListener {

    val TYPE = Type.fromClass(PluginMessageListener::class.java)
    private val BYTE_ARRAY = Type.fromClass(ByteArray::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginMessageListener::class.java)
                .function("onPluginMessageReceived", returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE, BYTE_ARRAY)) {
                    it.target?.onPluginMessageReceived(
                        it.getString(0)!!,
                        it.getRef(1) as Player,
                        it.getRef(2) as ByteArray
                    )
                }
        }
    }
}
