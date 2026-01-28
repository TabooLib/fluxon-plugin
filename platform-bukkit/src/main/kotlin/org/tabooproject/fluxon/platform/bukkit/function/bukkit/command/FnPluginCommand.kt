package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.command.TabCompleter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.command.PluginCommand"])
@PlatformSide(Platform.BUKKIT)
object FnPluginCommand {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginCommand::class.java)
                .function("execute", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.execute(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        it.getRef(2) as Array<String>
                    ))
                }
                .function("setExecutor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setExecutor(it.getRef(0) as CommandExecutor)) }
                .function("executor", returnsObject().noParams()) { it.setReturnRef(it.target?.executor) }
                .function("setTabCompleter", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTabCompleter(it.getRef(0) as TabCompleter)) }
                .function("tabCompleter", returnsObject().noParams()) { it.setReturnRef(it.target?.tabCompleter) }
                .function("plugin", returnsObject().noParams()) { it.setReturnRef(it.target?.plugin) }
                .function("tabComplete", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.tabComplete(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        it.getRef(2) as Array<String>
                    ))
                }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
