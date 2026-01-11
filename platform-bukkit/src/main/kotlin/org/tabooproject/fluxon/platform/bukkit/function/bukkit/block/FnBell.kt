package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Bell
import org.bukkit.block.BlockFace
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBell {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bell::class.java)
                .function("ring", 2) { it.target?.ring(it.getArgument(0) as Entity, it.getArgument(1) as BlockFace) }
                .function("ring", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Entity -> it.target?.ring(var1)
                        is BlockFace -> it.target?.ring(var1)
                    }
                }
                .function("ring", 0) { it.target?.ring() }
                .function("isShaking", 0) { it.target?.isShaking }
                .function("shakingTicks", 0) { it.target?.shakingTicks }
                .function("isResonating", 0) { it.target?.isResonating }
                .function("resonatingTicks", 0) { it.target?.resonatingTicks }
        }
    }
}
