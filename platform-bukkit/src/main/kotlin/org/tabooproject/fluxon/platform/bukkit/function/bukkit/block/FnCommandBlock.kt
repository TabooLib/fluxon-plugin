package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.CommandBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCommandBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandBlock::class.java)
                .function("command", 0) { it.target?.command }
                .function("setCommand", 1) { it.target?.setCommand(it.getString(0)) }
                .function("name", 0) { it.target?.name }
                .function("setName", 1) { it.target?.setName(it.getString(0)) }
        }
    }
}
