package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Sapling
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSapling {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sapling::class.java)
                .function("stage", 0) { it.target?.stage }
                .function("setStage", 1) { it.target?.setStage(it.getNumber(0).toInt()) }
                .function("maximumStage", 0) { it.target?.maximumStage }
        }
    }
}
