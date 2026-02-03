package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.MultipleCommandAlias
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.MultipleCommandAlias"])
@PlatformSide(Platform.BUKKIT)
object FnMultipleCommandAlias {

    val TYPE = Type.fromClass(MultipleCommandAlias::class.java)

    val commandArray = Type(Command::class.java, 1)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MultipleCommandAlias::class.java)
                .function("commands", returns(commandArray).noParams()) { it.setReturnRef(it.target?.commands) }
                .function("execute", returns(Type.Z).params(FnCommandSender.TYPE, Type.STRING, Type.LIST)) {
                    it.setReturnRef(it.target?.execute(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        (it.getRef(2) as List<String>).toTypedArray(),
                    ))
                }
        }
    }
}
