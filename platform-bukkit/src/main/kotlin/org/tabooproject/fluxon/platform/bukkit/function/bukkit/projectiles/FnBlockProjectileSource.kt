package org.tabooproject.fluxon.platform.bukkit.function.bukkit.projectiles

import org.bukkit.projectiles.BlockProjectileSource
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockProjectileSource {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockProjectileSource::class.java)
                .function("block", 0) { it.target?.block }
        }
    }
}
