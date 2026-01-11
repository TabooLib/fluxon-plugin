package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AnimalTamer
import org.bukkit.entity.Tameable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnTameable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tameable::class.java)
                .function("isTamed", 0) { it.target?.isTamed }
                .function("setTamed", 1) { it.target?.setTamed(it.getBoolean(0)) }
                .function("owner", 0) { it.target?.owner }
                .function("setOwner", 1) { it.target?.setOwner(it.getArgument(0) as AnimalTamer) }
        }
    }
}
