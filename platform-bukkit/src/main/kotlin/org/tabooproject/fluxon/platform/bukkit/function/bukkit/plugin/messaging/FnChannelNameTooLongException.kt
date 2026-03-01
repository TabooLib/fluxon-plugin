package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.plugin.messaging.ChannelNameTooLongException"])
@PlatformSide(Platform.BUKKIT)
object FnChannelNameTooLongException {

    val TYPE = Type.fromClass(org.bukkit.plugin.messaging.ChannelNameTooLongException::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.plugin.messaging.ChannelNameTooLongException::class.java)
                // static
        }
    }
}
