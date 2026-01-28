package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.minecart

import org.bukkit.entity.minecart.CommandMinecart
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.minecart.CommandMinecart"])
@PlatformSide(Platform.BUKKIT)
object FnCommandMinecart {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandMinecart::class.java)
                .function("command", returnsObject().noParams()) { it.target?.command }
                .function("setCommand", returnsObject().params(Type.OBJECT)) { it.target?.setCommand(it.getString(0)) }
                .function("setName", returnsObject().params(Type.OBJECT)) { it.target?.setName(it.getString(0)) }
        }
    }
}
