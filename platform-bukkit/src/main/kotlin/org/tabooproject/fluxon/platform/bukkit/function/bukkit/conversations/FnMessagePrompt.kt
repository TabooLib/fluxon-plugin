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

@Requires(classes = ["org.bukkit.conversations.MessagePrompt"])
@PlatformSide(Platform.BUKKIT)
object FnMessagePrompt {

    val TYPE = Type.fromClass(org.bukkit.conversations.MessagePrompt::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.MessagePrompt::class.java)
                .function("blocksForInput", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE)) { it.setReturnBool(it.target?.blocksForInput(it.getRef(0) as org.bukkit.conversations.ConversationContext) ?: false) }
                .function("acceptInput", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnPrompt.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnRef(it.target?.acceptInput(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1))) }
                // .function("getNextPrompt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnPrompt.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE)) { it.setReturnRef(it.target?.getNextPrompt(it.getRef(0) as org.bukkit.conversations.ConversationContext)) }
        }
    }
}
