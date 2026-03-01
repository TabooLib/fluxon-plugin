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

@Requires(classes = ["org.bukkit.conversations.ConversationAbandonedEvent"])
@PlatformSide(Platform.BUKKIT)
object FnConversationAbandonedEvent {

    val TYPE = Type.fromClass(org.bukkit.conversations.ConversationAbandonedEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.ConversationAbandonedEvent::class.java)
                .function("getCanceller", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationCanceller.TYPE).noParams()) { it.setReturnRef(it.target?.getCanceller()) }
                .function("getContext", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE).noParams()) { it.setReturnRef(it.target?.getContext()) }
                .function("gracefulExit", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.gracefulExit() ?: false) }
        }
    }
}
