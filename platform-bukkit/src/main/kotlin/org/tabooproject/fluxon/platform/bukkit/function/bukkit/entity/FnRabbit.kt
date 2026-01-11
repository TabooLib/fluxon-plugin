package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Rabbit
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnRabbit {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rabbit::class.java)
                .function("rabbitType", 0) { it.target?.rabbitType }
                .function("setRabbitType", 1) { it.target?.setRabbitType(it.getArgument(0) as Rabbit.Type) }
        }
    }
}
