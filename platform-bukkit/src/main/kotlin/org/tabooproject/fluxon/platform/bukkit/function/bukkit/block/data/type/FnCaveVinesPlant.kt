package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.CaveVinesPlant
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCaveVinesPlant {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CaveVinesPlant::class.java)
                .function("isBerries", 0) { it.target?.isBerries }
                .function("setBerries", 1) { it.target?.setBerries(it.getBoolean(0)) }
        }
    }
}
