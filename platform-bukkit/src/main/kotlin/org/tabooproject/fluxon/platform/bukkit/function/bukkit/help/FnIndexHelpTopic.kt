package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.command.CommandSender
import org.bukkit.help.IndexHelpTopic
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.help.IndexHelpTopic"])
@PlatformSide(Platform.BUKKIT)
object FnIndexHelpTopic {

    val TYPE = Type.fromClass(IndexHelpTopic::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(IndexHelpTopic::class.java)
                .function("canSee", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.canSee(it.getRef(0) as CommandSender) ?: false) }
                .function("amendCanSee", returnsVoid().params(Type.STRING)) { it.target?.amendCanSee(it.getString(0)) }
                .function("getFullText", returns(Type.STRING).params(Type.OBJECT)) { it.setReturnRef(it.target?.getFullText(it.getRef(0) as CommandSender)) }
        }
    }
}
