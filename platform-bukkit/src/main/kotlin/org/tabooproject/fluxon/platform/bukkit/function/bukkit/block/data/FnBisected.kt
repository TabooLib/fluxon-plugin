package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Bisected
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBisected {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bisected::class.java)
                .function("half", 0) { it.target?.half }
                .function("setHalf", 1) { it.target?.setHalf(it.getArgument(0) as Bisected.Half) }
        }
    }
}
