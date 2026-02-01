package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.help.HelpTopic
import org.bukkit.help.HelpTopicComparator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.help.HelpTopicComparator"])
@PlatformSide(Platform.BUKKIT)
object FnHelpTopicComparator {

    val TYPE = Type.fromClass(HelpTopicComparator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpTopicComparator::class.java)
                // static
                .function("topicNameComparatorInstance", returnsObject().noParams()) { it.setReturnRef(HelpTopicComparator.topicNameComparatorInstance()) }
                // static
                .function("helpTopicComparatorInstance", returnsObject().noParams()) { it.setReturnRef(HelpTopicComparator.helpTopicComparatorInstance()) }
                .function("compare", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.compare(
                        it.getRef(0) as HelpTopic,
                        it.getRef(1) as HelpTopic
                    ))
                }
        }
    }
}

@Requires(classes = ["org.bukkit.help.HelpTopicComparator.TopicNameComparator"])
@PlatformSide(Platform.BUKKIT)
object FnHelpTopicComparatorTopicNameComparator {

    val TYPE = Type.fromClass(HelpTopicComparator.TopicNameComparator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpTopicComparator.TopicNameComparator::class.java)
                .function("compare", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.compare(it.getString(0)!!, it.getRef(1) as String)) }
        }
    }
}
