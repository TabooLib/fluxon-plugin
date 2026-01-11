package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Camel
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCamel {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Camel::class.java)
                .function("isDashing", 0) { it.target?.isDashing }
                .function("setDashing", 1) { it.target?.setDashing(it.getBoolean(0)) }
        }
    }
}
