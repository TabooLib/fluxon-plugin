package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.command.Command
import org.bukkit.help.HelpTopicFactory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject

@Requires(classes = ["org.bukkit.help.HelpTopicFactory"])
@PlatformSide(Platform.BUKKIT)
object FnHelpTopicFactory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpTopicFactory::class.java)
                .function("createTopic", returnsObject().params(Type.OBJECT)) { it.setReturnRef((it.target as? HelpTopicFactory<Command>)?.createTopic(it.getRef(0) as Command)) }
        }
    }
}
