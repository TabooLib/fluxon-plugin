package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure

import org.bukkit.generator.structure.GeneratedStructure
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnGeneratedStructure {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GeneratedStructure::class.java)
                .function("boundingBox", 0) { it.target?.boundingBox }
                .function("structure", 0) { it.target?.structure }
                .function("pieces", 0) { it.target?.pieces }
        }
    }
}
