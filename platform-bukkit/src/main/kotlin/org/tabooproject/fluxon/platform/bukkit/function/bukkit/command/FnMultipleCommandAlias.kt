package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.CommandSender
import org.bukkit.command.MultipleCommandAlias
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMultipleCommandAlias {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MultipleCommandAlias::class.java)
                .function("commands", 0) { it.target?.commands }
                .function("execute", 3) {
                    it.target?.execute(
                        it.getArgument(0) as CommandSender,
                        it.getString(1)!!,
                        it.getArgument(2) as Array<String>
                    )
                }
        }
    }
}
