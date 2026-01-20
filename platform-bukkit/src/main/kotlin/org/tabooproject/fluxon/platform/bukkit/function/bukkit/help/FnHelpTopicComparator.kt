package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.help.HelpTopic
import org.bukkit.help.HelpTopicComparator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnHelpTopicComparator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpTopicComparator::class.java)
                // static
                .function("topicNameComparatorInstance", 0) { HelpTopicComparator.topicNameComparatorInstance() }
                // static
                .function("helpTopicComparatorInstance", 0) { HelpTopicComparator.helpTopicComparatorInstance() }
                .function("compare", 2) {
                    it.target?.compare(
                        it.getArgument(0) as HelpTopic,
                        it.getArgument(1) as HelpTopic
                    )
                }

            registerExtension(HelpTopicComparator.TopicNameComparator::class.java)
                .function("compare", 2) { it.target?.compare(it.getString(0)!!, it.getArgument(1) as String) }
        }
    }
}
