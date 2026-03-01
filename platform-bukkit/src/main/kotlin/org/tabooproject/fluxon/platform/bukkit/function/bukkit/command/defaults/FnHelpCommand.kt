package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.defaults

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.defaults.HelpCommand"])
@PlatformSide(Platform.BUKKIT)
object FnHelpCommand {

    val TYPE = Type.fromClass(org.bukkit.command.defaults.HelpCommand::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.command.defaults.HelpCommand::class.java)
                // static damerauLevenshteinDistance
                .function("execute", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE, Type.STRING, org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY)) { it.setReturnBool(it.target?.execute(it.getRef(0) as org.bukkit.command.CommandSender, it.getString(1), it.getRef(2) as Array<String>) ?: false) }
                .function("tabComplete", returns(Type.LIST).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE, Type.STRING, org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY)) { it.setReturnRef(it.target?.tabComplete(it.getRef(0) as org.bukkit.command.CommandSender, it.getString(1), it.getRef(2) as Array<String>)) }
                // .function("findPossibleMatches", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.help.FnHelpTopic.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.findPossibleMatches(it.getString(0))) }
        }
    }
}
