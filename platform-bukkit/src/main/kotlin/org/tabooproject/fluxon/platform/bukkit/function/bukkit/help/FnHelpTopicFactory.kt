package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.command.Command
import org.bukkit.help.HelpTopicFactory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnHelpTopicFactory {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpTopicFactory::class.java)
                .function(
                    "createTopic",
                    1
                ) { (it.target as? HelpTopicFactory<Command>)?.createTopic(it.getArgument(0) as Command) }
        }
    }
}
