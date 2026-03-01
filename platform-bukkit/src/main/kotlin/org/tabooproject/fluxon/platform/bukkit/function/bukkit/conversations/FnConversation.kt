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

@Requires(classes = ["org.bukkit.conversations.Conversation"])
@PlatformSide(Platform.BUKKIT)
object FnConversation {

    val TYPE = Type.fromClass(org.bukkit.conversations.Conversation::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.Conversation::class.java)
                .function("getForWhom", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversable.TYPE).noParams()) { it.setReturnRef(it.target?.getForWhom()) }
                .function("isModal", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isModal() ?: false) }
                // .function("setModal", returnsVoid().params(Type.Z)) { it.target?.setModal(it.getBool(0)) }
                .function("isLocalEchoEnabled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLocalEchoEnabled() ?: false) }
                .function("setLocalEchoEnabled", returnsVoid().params(Type.Z)) { it.target?.setLocalEchoEnabled(it.getBool(0)) }
                .function("getPrefix", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationPrefix.TYPE).noParams()) { it.setReturnRef(it.target?.getPrefix()) }
                // .function("setPrefix", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationPrefix.TYPE)) { it.target?.setPrefix(it.getRef(0) as org.bukkit.conversations.ConversationPrefix) }
                // .function("addConversationCanceller", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationCanceller.TYPE)) { it.target?.addConversationCanceller(it.getRef(0) as org.bukkit.conversations.ConversationCanceller) }
                .function("getCancellers", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.getCancellers()) }
                .function("getContext", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE).noParams()) { it.setReturnRef(it.target?.getContext()) }
                .function("begin", returnsVoid().noParams()) { it.target?.begin() }
                // .function("getState", returns(Type.fromClass(org.bukkit.conversations.ConversationState::class.java)).noParams()) { it.setReturnRef(it.target?.getState()) }
                .function("acceptInput", returnsVoid().params(Type.STRING)) { it.target?.acceptInput(it.getString(0)) }
                .function("addConversationAbandonedListener", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationAbandonedListener.TYPE)) { it.target?.addConversationAbandonedListener(it.getRef(0) as org.bukkit.conversations.ConversationAbandonedListener) }
                .function("removeConversationAbandonedListener", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationAbandonedListener.TYPE)) { it.target?.removeConversationAbandonedListener(it.getRef(0) as org.bukkit.conversations.ConversationAbandonedListener) }
                .function("abandon", returnsVoid().noParams()) { it.target?.abandon() }
                .function("abandon", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationAbandonedEvent.TYPE)) { it.target?.abandon(it.getRef(0) as org.bukkit.conversations.ConversationAbandonedEvent) }
                .function("outputNextPrompt", returnsVoid().noParams()) { it.target?.outputNextPrompt() }
        }
    }
}
