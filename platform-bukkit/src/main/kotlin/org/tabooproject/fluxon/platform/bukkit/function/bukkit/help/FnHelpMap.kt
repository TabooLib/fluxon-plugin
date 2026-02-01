package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.help.HelpMap
import org.bukkit.help.HelpTopic
import org.bukkit.help.HelpTopicFactory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.help.HelpMap"])
@PlatformSide(Platform.BUKKIT)
object FnHelpMap {

    val TYPE = Type.fromClass(HelpMap::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpMap::class.java)
                .function("getHelpTopic", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getHelpTopic(it.getString(0)!!)) }
                .function("helpTopics", returnsObject().noParams()) { it.setReturnRef(it.target?.helpTopics) }
                .function("addTopic", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addTopic(it.getRef(0) as HelpTopic)) }
                .function("clear", returnsObject().noParams()) { it.setReturnRef(it.target?.clear()) }
                .function("registerHelpTopicFactory", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.registerHelpTopicFactory(
                        Class.forName(it.getString(0)),
                        it.getRef(1) as HelpTopicFactory<*>
                    ))
                }
                .function("ignoredPlugins", returnsObject().noParams()) { it.setReturnRef(it.target?.ignoredPlugins) }
        }
    }
}
