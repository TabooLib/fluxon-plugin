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

@Requires(classes = ["org.bukkit.conversations.NumericPrompt"])
@PlatformSide(Platform.BUKKIT)
object FnNumericPrompt {

    val TYPE = Type.fromClass(org.bukkit.conversations.NumericPrompt::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.NumericPrompt::class.java)
                // .function("isInputValid", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnBool(it.target?.isInputValid(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1)) ?: false) }
                // .function("isNumberValid", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.fromClass(org.bukkit.conversations.Number::class.java))) { it.setReturnBool(it.target?.isNumberValid(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getRef(1) as org.bukkit.conversations.Number) ?: false) }
                // .function("acceptValidatedInput", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnPrompt.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnRef(it.target?.acceptValidatedInput(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1))) }
                // .function("acceptValidatedInput", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnPrompt.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.fromClass(org.bukkit.conversations.Number::class.java))) { it.setReturnRef(it.target?.acceptValidatedInput(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getRef(1) as org.bukkit.conversations.Number)) }
                // .function("getFailedValidationText", returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnRef(it.target?.getFailedValidationText(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1))) }
                // .function("getInputNotNumericText", returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnRef(it.target?.getInputNotNumericText(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1))) }
                // .function("getFailedValidationText", returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.fromClass(org.bukkit.conversations.Number::class.java))) { it.setReturnRef(it.target?.getFailedValidationText(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getRef(1) as org.bukkit.conversations.Number)) }
        }
    }
}
