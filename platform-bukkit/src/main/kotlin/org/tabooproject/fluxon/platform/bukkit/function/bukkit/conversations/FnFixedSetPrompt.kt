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

@Requires(classes = ["org.bukkit.conversations.FixedSetPrompt"])
@PlatformSide(Platform.BUKKIT)
object FnFixedSetPrompt {

    val TYPE = Type.fromClass(org.bukkit.conversations.FixedSetPrompt::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.FixedSetPrompt::class.java)
                // .function("isInputValid", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE, Type.STRING)) { it.setReturnBool(it.target?.isInputValid(it.getRef(0) as org.bukkit.conversations.ConversationContext, it.getString(1)) ?: false) }
                // .function("formatFixedSet", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.formatFixedSet()) }
        }
    }
}
