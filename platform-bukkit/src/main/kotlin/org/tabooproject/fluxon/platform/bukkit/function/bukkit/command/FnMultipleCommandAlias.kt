package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.CommandSender
import org.bukkit.command.MultipleCommandAlias
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.command.MultipleCommandAlias"])
@PlatformSide(Platform.BUKKIT)
object FnMultipleCommandAlias {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MultipleCommandAlias::class.java)
                .function("commands", returnsObject().noParams()) { it.setReturnRef(it.target?.commands) }
                .function("execute", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.execute(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        it.getRef(2) as Array<String>
                    ))
                }
        }
    }
}
