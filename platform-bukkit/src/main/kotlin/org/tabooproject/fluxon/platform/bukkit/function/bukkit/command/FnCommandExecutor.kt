package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.command.CommandExecutor"])
@PlatformSide(Platform.BUKKIT)
object FnCommandExecutor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandExecutor::class.java)
                .function("onCommand", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.onCommand(
                        it.getRef(0) as CommandSender,
                        it.getRef(1) as Command,
                        it.getString(2)!!,
                        it.getRef(3) as Array<String>,
                    )
                }
        }
    }
}
