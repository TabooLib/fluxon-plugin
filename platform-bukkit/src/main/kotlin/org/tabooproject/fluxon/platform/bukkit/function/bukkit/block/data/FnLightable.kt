package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Lightable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnLightable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lightable::class.java)
                .function("isLit", 0) { it.target?.isLit }
                .function("setLit", 1) { it.target?.setLit(it.getBoolean(0)) }
        }
    }
}
