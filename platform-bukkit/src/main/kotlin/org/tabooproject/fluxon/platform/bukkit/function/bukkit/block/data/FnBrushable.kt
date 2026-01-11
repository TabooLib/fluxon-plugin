package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Brushable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBrushable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Brushable::class.java)
                .function("dusted", 0) { it.target?.dusted }
                .function("setDusted", 1) { it.target?.setDusted(it.getNumber(0).toInt()) }
                .function("maximumDusted", 0) { it.target?.maximumDusted }
        }
    }
}
