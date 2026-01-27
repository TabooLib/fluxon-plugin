package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.BlockCommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.command.BlockCommandSender"])
@PlatformSide(Platform.BUKKIT)
object FnBlockCommandSender {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockCommandSender::class.java)
                .function("block", 0) { it.target?.block }
        }
    }
}
