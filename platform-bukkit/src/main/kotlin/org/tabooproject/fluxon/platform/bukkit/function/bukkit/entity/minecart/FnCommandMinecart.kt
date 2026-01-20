package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.minecart

import org.bukkit.entity.minecart.CommandMinecart
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCommandMinecart {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandMinecart::class.java)
                .function("command", 0) { it.target?.command }
                .function("setCommand", 1) { it.target?.setCommand(it.getString(0)) }
                .function("setName", 1) { it.target?.setName(it.getString(0)) }
        }
    }
}
