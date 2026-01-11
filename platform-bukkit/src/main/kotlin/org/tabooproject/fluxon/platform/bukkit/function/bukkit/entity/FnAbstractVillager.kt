package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractVillager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAbstractVillager {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractVillager::class.java)
                .function("inventory", 0) { it.target?.inventory }
        }
    }
}
