package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.WoodenStep
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnWoodenStep {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WoodenStep::class.java)
                .function("isInverted", 0) { it.target?.isInverted }
                .function("setInverted", 1) { it.target?.setInverted(it.getBoolean(0)) }
                .function("clone", 0) { it.target?.clone() }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
