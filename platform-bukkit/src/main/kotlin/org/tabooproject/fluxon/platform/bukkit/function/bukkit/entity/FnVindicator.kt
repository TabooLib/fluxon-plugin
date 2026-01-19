package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Vindicator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnVindicator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vindicator::class.java)
                .function("isJohnny", 0) { it.target?.isJohnny }
                .function("setJohnny", 1) { it.target?.setJohnny(it.getBoolean(0)) }
        }
    }
}
