package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.command.TabCompleter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.PluginCommand"])
@PlatformSide(Platform.BUKKIT)
object FnPluginCommand {

    val TYPE = Type.fromClass(PluginCommand::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginCommand::class.java)
                .function("execute", returns(Type.Z).params(FnCommandSender.TYPE, Type.STRING, Type.LIST)) {
                    it.setReturnBool(it.target?.execute(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        (it.getRef(2) as List<String>).toTypedArray(),
                    ) == true)
                }
                .function("setExecutor", returnsVoid().params(FnCommandExecutor.TYPE)) { it.target?.setExecutor(it.getRef(0) as CommandExecutor) }
                .function("executor", returns(FnCommandExecutor.TYPE).noParams()) { it.setReturnRef(it.target?.executor) }
                .function("setTabCompleter", returnsVoid().params(FnTabCompleter.TYPE)) { it.target?.setTabCompleter(it.getRef(0) as TabCompleter) }
                .function("tabCompleter", returns(FnTabCompleter.TYPE).noParams()) { it.setReturnRef(it.target?.tabCompleter) }
                .function("plugin", returns(FnPlugin.TYPE).noParams()) { it.setReturnRef(it.target?.plugin) }
                .function("tabComplete", returns(Type.LIST).params(FnCommandSender.TYPE, Type.STRING, Type.LIST)) {
                    it.setReturnRef(it.target?.tabComplete(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        (it.getRef(2) as List<String>).toTypedArray(),
                    ))
                }
        }
    }
}
