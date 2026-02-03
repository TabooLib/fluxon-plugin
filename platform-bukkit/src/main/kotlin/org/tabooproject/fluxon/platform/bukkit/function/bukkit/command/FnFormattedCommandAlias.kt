package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.CommandSender
import org.bukkit.command.FormattedCommandAlias
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.FormattedCommandAlias"])
@PlatformSide(Platform.BUKKIT)
object FnFormattedCommandAlias {

    val TYPE = Type.fromClass(FormattedCommandAlias::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FormattedCommandAlias::class.java)
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
