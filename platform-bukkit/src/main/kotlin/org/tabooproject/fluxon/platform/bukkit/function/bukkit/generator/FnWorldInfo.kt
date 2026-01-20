package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.generator.WorldInfo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWorldInfo {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldInfo::class.java)
                .function("name", 0) { it.target?.name }
                .function("uID", 0) { it.target?.uid }
                .function("seed", 0) { it.target?.seed }
                .function("minHeight", 0) { it.target?.minHeight }
                .function("maxHeight", 0) { it.target?.maxHeight }
        }
    }
}
