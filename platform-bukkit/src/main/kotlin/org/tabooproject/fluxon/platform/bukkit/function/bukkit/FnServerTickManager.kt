package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.ServerTickManager
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.ServerTickManager"])
@PlatformSide(Platform.BUKKIT)
object FnServerTickManager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerTickManager::class.java)
                .function("isRunningNormally", 0) { it.target?.isRunningNormally }
                .function("isStepping", 0) { it.target?.isStepping }
                .function("isSprinting", 0) { it.target?.isSprinting }
                .function("isFrozen", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.isFrozen
                    } else {
                        it.target?.isFrozen(it.getArgument(0) as Entity)
                    }
                }
                .function("tickRate", 0) { it.target?.tickRate }
                .function("setTickRate", 1) { it.target?.setTickRate(it.getNumber(0).toFloat()) }
                .function("setFrozen", 1) { it.target?.setFrozen(it.getBoolean(0)) }
                .function("stepGameIfFrozen", 1) { it.target?.stepGameIfFrozen(it.getNumber(0).toInt()) }
                .function("stopStepping", 0) { it.target?.stopStepping() }
                .function("requestGameToSprint", 1) { it.target?.requestGameToSprint(it.getNumber(0).toInt()) }
                .function("stopSprinting", 0) { it.target?.stopSprinting() }
                .function("frozenTicksToRun", 0) { it.target?.frozenTicksToRun }
        }
    }
}
