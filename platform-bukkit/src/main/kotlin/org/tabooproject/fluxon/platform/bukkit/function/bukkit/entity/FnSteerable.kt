package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Steerable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Steerable"])
@PlatformSide(Platform.BUKKIT)
object FnSteerable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Steerable::class.java)
                .function("hasSaddle", 0) { it.target?.hasSaddle() }
                .function("setSaddle", 1) { it.target?.setSaddle(it.getBoolean(0)) }
                .function("boostTicks", 0) { it.target?.boostTicks }
                .function("setBoostTicks", 1) { it.target?.setBoostTicks(it.getNumber(0).toInt()) }
                .function("currentBoostTicks", 0) { it.target?.currentBoostTicks }
                .function("setCurrentBoostTicks", 1) { it.target?.setCurrentBoostTicks(it.getNumber(0).toInt()) }
                .function("steerMaterial", 0) { it.target?.steerMaterial }
        }
    }
}
