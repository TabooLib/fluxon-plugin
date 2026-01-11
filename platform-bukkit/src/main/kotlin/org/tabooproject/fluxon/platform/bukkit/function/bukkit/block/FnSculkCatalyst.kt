package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Block
import org.bukkit.block.SculkCatalyst
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSculkCatalyst {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkCatalyst::class.java)
                .function("bloom", 2) { it.target?.bloom(it.getArgument(0) as Block, it.getNumber(1).toInt()) }
        }
    }
}
