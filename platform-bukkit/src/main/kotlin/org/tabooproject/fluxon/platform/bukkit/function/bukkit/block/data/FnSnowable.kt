package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Snowable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSnowable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Snowable::class.java)
                .function("isSnowy", 0) { it.target?.isSnowy }
                .function("setSnowy", 1) { it.target?.setSnowy(it.getBoolean(0)) }
        }
    }
}
