package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure

import org.bukkit.generator.structure.StructureType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnStructureType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureType::class.java)
        }
    }
}
