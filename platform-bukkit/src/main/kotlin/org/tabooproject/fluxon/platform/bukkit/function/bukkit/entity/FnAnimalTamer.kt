package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AnimalTamer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAnimalTamer {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AnimalTamer::class.java)
                .function("name", 0) { it.target?.name }
                .function("uniqueId", 0) { it.target?.uniqueId }
        }
    }
}
