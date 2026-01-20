package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.help.HelpMap
import org.bukkit.help.HelpTopic
import org.bukkit.help.HelpTopicFactory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnHelpMap {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpMap::class.java)
                .function("helpTopic", 1) { it.target?.getHelpTopic(it.getString(0)!!) }
                .function("helpTopics", 0) { it.target?.helpTopics }
                .function("addTopic", 1) { it.target?.addTopic(it.getArgument(0) as HelpTopic) }
                .function("clear", 0) { it.target?.clear() }
                .function(
                    "registerHelpTopicFactory",
                    2
                ) {
                    it.target?.registerHelpTopicFactory(
                        Class.forName(it.getString(0)),
                        it.getArgument(1) as HelpTopicFactory<*>
                    )
                }
                .function("ignoredPlugins", 0) { it.target?.ignoredPlugins }
        }
    }
}
