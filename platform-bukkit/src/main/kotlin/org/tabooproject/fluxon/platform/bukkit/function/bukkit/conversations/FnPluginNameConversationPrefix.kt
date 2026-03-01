package org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.conversations.PluginNameConversationPrefix"])
@PlatformSide(Platform.BUKKIT)
object FnPluginNameConversationPrefix {

    val TYPE = Type.fromClass(org.bukkit.conversations.PluginNameConversationPrefix::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.PluginNameConversationPrefix::class.java)
                .function("getPrefix", returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE)) { it.setReturnRef(it.target?.getPrefix(it.getRef(0) as org.bukkit.conversations.ConversationContext)) }
        }
    }
}
