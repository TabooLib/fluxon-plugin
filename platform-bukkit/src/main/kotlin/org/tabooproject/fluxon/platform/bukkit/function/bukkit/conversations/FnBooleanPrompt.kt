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

@Requires(classes = ["org.bukkit.conversations.BooleanPrompt"])
@PlatformSide(Platform.BUKKIT)
object FnBooleanPrompt {

    val TYPE = Type.fromClass(org.bukkit.conversations.BooleanPrompt::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.BooleanPrompt::class.java)
                // .function("isInputValid", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnBool(it.target?.isInputValid(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1)) ?: false) }
                // .function("acceptValidatedInput", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnPrompt.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnRef(it.target?.acceptValidatedInput(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1))) }
                // .function("acceptValidatedInput", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnPrompt.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.Z)) { it.setReturnRef(it.target?.acceptValidatedInput(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getBool(1))) }
        }
    }
}
