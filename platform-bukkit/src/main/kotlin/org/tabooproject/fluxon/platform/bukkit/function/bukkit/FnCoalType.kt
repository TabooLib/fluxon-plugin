package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.CoalType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCoalType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CoalType::class.java)
                .function("data", 0) { it.target?.data }
                // static
                .function("byData", 1) { CoalType.getByData(it.getNumber(0).toByte()) }
        }
    }
}
