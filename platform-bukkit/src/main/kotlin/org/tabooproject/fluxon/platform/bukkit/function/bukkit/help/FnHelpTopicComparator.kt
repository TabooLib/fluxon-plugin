package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.help.HelpTopicComparator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

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
                    // int compare(@NotNull HelpTopic lhs, @NotNull HelpTopic rhs)
                    // int compare(@NotNull String lhs, @NotNull String rhs)
                    TODO()
                }
        }
    }
}
