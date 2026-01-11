package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMob {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Mob::class.java)
                .function("setTarget", 1) { it.target?.setTarget(it.getArgument(0) as LivingEntity) }
                .function("target", 0) { it.target?.target }
                .function("setAware", 1) { it.target?.setAware(it.getBoolean(0)) }
                .function("isAware", 0) { it.target?.isAware }
                .function("ambientSound", 0) { it.target?.ambientSound }
        }
    }
}
