package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.TreeSpecies
import org.bukkit.material.Wood
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnWood {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wood::class.java)
                .function("species", 0) { it.target?.species }
                .function("setSpecies", 1) { it.target?.setSpecies(it.getArgument(0) as TreeSpecies) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
