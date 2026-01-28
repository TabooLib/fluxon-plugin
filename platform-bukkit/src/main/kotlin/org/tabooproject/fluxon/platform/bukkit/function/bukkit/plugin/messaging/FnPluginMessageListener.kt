package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.entity.Player
import org.bukkit.plugin.messaging.PluginMessageListener
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.plugin.messaging.PluginMessageListener"])
@PlatformSide(Platform.BUKKIT)
object FnPluginMessageListener {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginMessageListener::class.java)
                .function("onPluginMessageReceived", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.onPluginMessageReceived(
                        it.getString(0)!!,
                        it.getRef(1) as Player,
                        it.getRef(2) as ByteArray
                    ))
                }
        }
    }
}
