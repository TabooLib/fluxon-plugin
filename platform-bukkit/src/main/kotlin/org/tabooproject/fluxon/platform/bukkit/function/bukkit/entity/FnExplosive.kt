package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Explosive
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnExplosive {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Explosive::class.java)
                .function("setYield", 1) { it.target?.setYield(it.getNumber(0).toFloat()) }
                .function("yield", 0) { it.target?.yield }
                .function("setIsIncendiary", 1) { it.target?.setIsIncendiary(it.getBoolean(0)) }
                .function("isIncendiary", 0) { it.target?.isIncendiary }
        }
    }
}
