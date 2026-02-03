package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.command.TabCompleter"])
@PlatformSide(Platform.BUKKIT)
object FnTabCompleter {

    val TYPE = Type.fromClass(TabCompleter::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TabCompleter::class.java)
                .function("onTabComplete", returns(Type.LIST).params(FnCommandSender.TYPE, FnCommand.TYPE, Type.STRING, Type.LIST)) {
                    it.setReturnRef(it.target?.onTabComplete(
                        it.getRef(0) as CommandSender,
                        it.getRef(1) as Command,
                        it.getString(2)!!,
                        (it.getRef(3) as List<String>).toTypedArray()
                    ))
                }
        }
    }
}
