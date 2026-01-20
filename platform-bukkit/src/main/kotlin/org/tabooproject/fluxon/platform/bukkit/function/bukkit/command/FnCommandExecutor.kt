package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCommandExecutor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandExecutor::class.java)
                .function("onCommand", 4) {
                    it.target?.onCommand(
                        it.getArgument(0) as CommandSender,
                        it.getArgument(1) as Command,
                        it.getString(2)!!,
                        it.getArgument(3) as Array<String>,
                    )
                }
        }
    }
}
