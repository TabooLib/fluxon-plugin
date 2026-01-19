package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Bamboo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBamboo {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bamboo::class.java)
                .function("leaves", 0) { it.target?.leaves }
                .function("setLeaves", 1) { it.target?.setLeaves(it.getArgument(0) as Bamboo.Leaves) }
        }
    }
}
