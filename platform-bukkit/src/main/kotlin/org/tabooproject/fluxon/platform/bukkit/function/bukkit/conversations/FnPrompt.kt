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

@Requires(classes = ["org.bukkit.conversations.Prompt"])
@PlatformSide(Platform.BUKKIT)
object FnPrompt {

    val TYPE = Type.fromClass(org.bukkit.conversations.Prompt::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.Prompt::class.java)
                .function("getPromptText", returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE)) { it.setReturnRef(it.target?.getPromptText(it.getRef(0) as org.bukkit.conversations.ConversationContext)) }
                .function("blocksForInput", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE)) { it.setReturnBool(it.target?.blocksForInput(it.getRef(0) as org.bukkit.conversations.ConversationContext) ?: false) }
                .function("acceptInput", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnPrompt.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnRef(it.target?.acceptInput(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1))) }
        }
    }
}
