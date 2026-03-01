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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.help.HelpMap"])
@PlatformSide(Platform.BUKKIT)
object FnHelpMap {

    val TYPE = Type.fromClass(HelpMap::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpMap::class.java)
                .function("getHelpTopic",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.help.FnHelpTopic.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getHelpTopic(it.getString(0)!!)) }
                .function("helpTopics",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.helpTopics) }
                .function("addTopic", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.help.FnHelpTopic.TYPE)) { it.target?.addTopic(it.getRef(0) as HelpTopic) }
                .function("clear", returnsVoid().noParams()) { it.target?.clear() }
                .function("registerHelpTopicFactory", returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.help.FnHelpTopicFactory.TYPE)) {
                    it.target?.registerHelpTopicFactory(
                        Class.forName(it.getString(0)),
                        it.getRef(1) as HelpTopicFactory<*>
                    )
                }
                .function("ignoredPlugins",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.ignoredPlugins) }
        }
    }
}
