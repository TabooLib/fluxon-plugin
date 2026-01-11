package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Cauldron
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCauldron {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cauldron::class.java)
                .function("isFull", 0) { it.target?.isFull }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
