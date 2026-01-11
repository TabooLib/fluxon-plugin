package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Strider
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnStrider {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Strider::class.java)
                .function("isShivering", 0) { it.target?.isShivering }
                .function("setShivering", 1) { it.target?.setShivering(it.getBoolean(0)) }
        }
    }
}
