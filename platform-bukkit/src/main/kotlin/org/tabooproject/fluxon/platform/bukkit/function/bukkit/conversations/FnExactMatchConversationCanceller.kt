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

@Requires(classes = ["org.bukkit.conversations.ExactMatchConversationCanceller"])
@PlatformSide(Platform.BUKKIT)
object FnExactMatchConversationCanceller {

    val TYPE = Type.fromClass(org.bukkit.conversations.ExactMatchConversationCanceller::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.ExactMatchConversationCanceller::class.java)
                .function("setConversation", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversation.TYPE)) { it.target?.setConversation(it.getRef(0) as org.bukkit.conversations.Conversation) }
                .function("cancelBasedOnInput", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnBool(it.target?.cancelBasedOnInput(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1)) ?: false) }
                .function("clone", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationCanceller.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
