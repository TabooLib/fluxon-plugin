package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure

import org.bukkit.generator.structure.Structure
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnStructure {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Structure::class.java)
                .function("structureType", 0) { it.target?.structureType }
        }
    }
}
