package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EnderDragonPart
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEnderDragonPart {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderDragonPart::class.java)
                .function("parent", 0) { it.target?.parent }
        }
    }
}
