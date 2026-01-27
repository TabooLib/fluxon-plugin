package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.command.CommandSender
import org.bukkit.help.HelpTopic
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.help.HelpTopic"])
@PlatformSide(Platform.BUKKIT)
object FnHelpTopic {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpTopic::class.java)
                .function("canSee", 1) { it.target?.canSee(it.getArgument(0) as CommandSender) }
                .function("amendCanSee", 1) { it.target?.amendCanSee(it.getString(0)) }
                .function("name", 0) { it.target?.getName() }
                .function("shortText", 0) { it.target?.getShortText() }
                .function("getFullText", 1) { it.target?.getFullText(it.getArgument(0) as CommandSender) }
                .function("amendTopic", 2) { it.target?.amendTopic(it.getString(0), it.getString(1)) }
        }
    }
}
