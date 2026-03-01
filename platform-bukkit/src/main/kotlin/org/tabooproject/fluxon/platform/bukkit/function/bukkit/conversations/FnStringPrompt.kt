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

@Requires(classes = ["org.bukkit.conversations.StringPrompt"])
@PlatformSide(Platform.BUKKIT)
object FnStringPrompt {

    val TYPE = Type.fromClass(org.bukkit.conversations.StringPrompt::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.StringPrompt::class.java)
                .function("blocksForInput", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversationContext.TYPE)) { it.setReturnBool(it.target?.blocksForInput(it.getRef(0) as org.bukkit.conversations.ConversationContext) ?: false) }
        }
    }
}
