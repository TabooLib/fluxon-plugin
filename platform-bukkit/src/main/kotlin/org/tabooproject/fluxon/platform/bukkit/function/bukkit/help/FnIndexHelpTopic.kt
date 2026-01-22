package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.command.CommandSender
import org.bukkit.help.IndexHelpTopic
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnIndexHelpTopic {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(IndexHelpTopic::class.java)
                .function("canSee", 1) { it.target?.canSee(it.getArgument(0) as CommandSender) }
                .function("amendCanSee", 1) { it.target?.amendCanSee(it.getString(0)) }
                .function("getFullText", 1) { it.target?.getFullText(it.getArgument(0) as CommandSender) }
        }
    }
}
