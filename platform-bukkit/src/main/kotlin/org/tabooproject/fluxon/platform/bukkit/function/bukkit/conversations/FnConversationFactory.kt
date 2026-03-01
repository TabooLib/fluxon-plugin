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

@Requires(classes = ["org.bukkit.conversations.ConversationFactory"])
@PlatformSide(Platform.BUKKIT)
object FnConversationFactory {

    val TYPE = Type.fromClass(org.bukkit.conversations.ConversationFactory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.ConversationFactory::class.java)
                .function("withModality", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.withModality(it.getBool(0))) }
                .function("withLocalEcho", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(Type.Z)) { it.setReturnRef(it.target?.withLocalEcho(it.getBool(0))) }
                .function("withPrefix", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationPrefix.TYPE)) { it.setReturnRef(it.target?.withPrefix(it.getRef(0) as org.bukkit.conversations.ConversationPrefix)) }
                .function("withTimeout", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(Type.I)) { it.setReturnRef(it.target?.withTimeout(it.getInt(0).toInt())) }
                .function("withFirstPrompt", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnPrompt.TYPE)) { it.setReturnRef(it.target?.withFirstPrompt(it.getRef(0) as org.bukkit.conversations.Prompt)) }
                // .function("withInitialSessionData", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(Type.MAP)) { it.setReturnRef(it.target?.withInitialSessionData(it.getRef(0) as java.util.Map)) }
                .function("withEscapeSequence", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.withEscapeSequence(it.getString(0))) }
                .function("withConversationCanceller", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationCanceller.TYPE)) { it.setReturnRef(it.target?.withConversationCanceller(it.getRef(0) as org.bukkit.conversations.ConversationCanceller)) }
                .function("thatExcludesNonPlayersWithMessage", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.thatExcludesNonPlayersWithMessage(it.getString(0))) }
                .function("addConversationAbandonedListener", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationFactory.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationAbandonedListener.TYPE)) { it.setReturnRef(it.target?.addConversationAbandonedListener(it.getRef(0) as org.bukkit.conversations.ConversationAbandonedListener)) }
                .function("buildConversation", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversation.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversable.TYPE)) { it.setReturnRef(it.target?.buildConversation(it.getRef(0) as org.bukkit.conversations.Conversable)) }
        }
    }
}
