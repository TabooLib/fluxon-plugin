package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Vex
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnVex {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vex::class.java)
                .function("isCharging", 0) { it.target?.isCharging }
                .function("setCharging", 1) { it.target?.setCharging(it.getBoolean(0)) }
                .function("bound", 0) { it.target?.bound }
                .function("setBound", 1) { it.target?.setBound(it.getArgument(0) as Location) }
                .function("lifeTicks", 0) { it.target?.lifeTicks }
                .function("setLifeTicks", 1) { it.target?.setLifeTicks(it.getNumber(0).toInt()) }
                .function("hasLimitedLife", 0) { it.target?.hasLimitedLife() }
        }
    }
}
