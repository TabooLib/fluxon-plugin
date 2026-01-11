package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Dispenser
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnDispenser {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Dispenser::class.java)
                .function("isTriggered", 0) { it.target?.isTriggered }
                .function("setTriggered", 1) { it.target?.setTriggered(it.getBoolean(0)) }
        }
    }
}
