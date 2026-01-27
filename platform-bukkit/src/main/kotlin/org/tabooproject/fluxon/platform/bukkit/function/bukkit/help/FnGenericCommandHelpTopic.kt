package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.command.CommandSender
import org.bukkit.help.GenericCommandHelpTopic
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.help.GenericCommandHelpTopic"])
@PlatformSide(Platform.BUKKIT)
object FnGenericCommandHelpTopic {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GenericCommandHelpTopic::class.java)
                .function("canSee", 1) { it.target?.canSee(it.getArgument(0) as CommandSender) }
        }
    }
}
