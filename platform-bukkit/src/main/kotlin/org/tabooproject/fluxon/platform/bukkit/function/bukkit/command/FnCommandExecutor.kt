package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.CommandExecutor"])
@PlatformSide(Platform.BUKKIT)
object FnCommandExecutor {

    val TYPE = Type.fromClass(CommandExecutor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandExecutor::class.java)
                .function("onCommand", returns(Type.Z).params(FnCommandSender.TYPE, FnCommand.TYPE, Type.STRING, Type.LIST)) {
                    it.setReturnRef(it.target?.onCommand(
                        it.getRef(0) as CommandSender,
                        it.getRef(1) as Command,
                        it.getString(2)!!,
                        (it.getRef(3) as List<String>).toTypedArray()
                    ))
                }
        }
    }
}
