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

@Requires(classes = ["org.bukkit.conversations.ConversationContext"])
@PlatformSide(Platform.BUKKIT)
object FnConversationContext {

    val TYPE = Type.fromClass(org.bukkit.conversations.ConversationContext::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.conversations.ConversationContext::class.java)
                .function("getPlugin", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE).noParams()) { it.setReturnRef(it.target?.getPlugin()) }
                .function("getForWhom", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.conversations.FnConversable.TYPE).noParams()) { it.setReturnRef(it.target?.getForWhom()) }
                .function("getAllSessionData", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.getAllSessionData()) }
                .function("getSessionData", returns(Type.OBJECT).params(Type.OBJECT)) { it.setReturnRef(it.target?.getSessionData(it.getRef(0) as java.lang.Object)) }
                .function("setSessionData", returnsVoid().params(Type.OBJECT, Type.OBJECT)) { it.target?.setSessionData(it.getRef(0) as java.lang.Object, it.getRef(1) as java.lang.Object) }
        }
    }
}
