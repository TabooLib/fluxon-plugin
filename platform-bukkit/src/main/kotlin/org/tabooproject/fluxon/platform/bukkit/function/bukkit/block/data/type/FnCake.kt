package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Cake
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCake {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cake::class.java)
                .function("bites", 0) { it.target?.bites }
                .function("setBites", 1) { it.target?.setBites(it.getNumber(0).toInt()) }
                .function("maximumBites", 0) { it.target?.maximumBites }
        }
    }
}
