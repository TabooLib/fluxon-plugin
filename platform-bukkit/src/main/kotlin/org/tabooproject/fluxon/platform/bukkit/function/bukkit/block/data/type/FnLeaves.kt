package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Leaves
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnLeaves {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Leaves::class.java)
                .function("isPersistent", 0) { it.target?.isPersistent }
                .function("setPersistent", 1) { it.target?.setPersistent(it.getBoolean(0)) }
                .function("distance", 0) { it.target?.distance }
                .function("setDistance", 1) { it.target?.setDistance(it.getNumber(0).toInt()) }
        }
    }
}
