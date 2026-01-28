package org.tabooproject.fluxon.platform.bukkit.function.bukkit.help

import org.bukkit.command.CommandSender
import org.bukkit.help.HelpTopic
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.help.HelpTopic"])
@PlatformSide(Platform.BUKKIT)
object FnHelpTopic {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HelpTopic::class.java)
                .function("canSee", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.canSee(it.getRef(0) as CommandSender)) }
                .function("amendCanSee", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.amendCanSee(it.getString(0))) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.getName()) }
                .function("shortText", returnsObject().noParams()) { it.setReturnRef(it.target?.getShortText()) }
                .function("getFullText", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getFullText(it.getRef(0) as CommandSender)) }
                .function("amendTopic", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.amendTopic(it.getString(0), it.getString(1))) }
        }
    }
}
