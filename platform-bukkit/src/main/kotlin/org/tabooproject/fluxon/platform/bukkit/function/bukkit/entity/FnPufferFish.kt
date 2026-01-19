package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.PufferFish
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPufferFish {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PufferFish::class.java)
                .function("puffState", 0) { it.target?.puffState }
                .function("setPuffState", 1) { it.target?.setPuffState(it.getNumber(0).toInt()) }
        }
    }
}
