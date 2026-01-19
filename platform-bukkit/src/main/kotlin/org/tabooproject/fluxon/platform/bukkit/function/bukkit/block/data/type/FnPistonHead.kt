package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.PistonHead
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPistonHead {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PistonHead::class.java)
                .function("isShort", 0) { it.target?.isShort }
                .function("setShort", 1) { it.target?.setShort(it.getBoolean(0)) }
        }
    }
}
