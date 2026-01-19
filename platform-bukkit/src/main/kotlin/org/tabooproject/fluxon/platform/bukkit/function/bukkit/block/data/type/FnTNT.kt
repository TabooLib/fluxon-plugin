package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.TNT
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnTNT {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TNT::class.java)
                .function("isUnstable", 0) { it.target?.isUnstable }
                .function("setUnstable", 1) { it.target?.setUnstable(it.getBoolean(0)) }
        }
    }
}
