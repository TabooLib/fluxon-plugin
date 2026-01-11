package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure

import org.bukkit.generator.structure.StructurePiece
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnStructurePiece {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructurePiece::class.java)
                .function("boundingBox", 0) { it.target?.boundingBox }
        }
    }
}
