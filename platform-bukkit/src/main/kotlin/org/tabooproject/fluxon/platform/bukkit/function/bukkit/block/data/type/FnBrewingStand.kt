package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.BrewingStand
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBrewingStand {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStand::class.java)
                .function("hasBottle", 1) { it.target?.hasBottle(it.getNumber(0).toInt()) }
                .function("setBottle", 2) { it.target?.setBottle(it.getNumber(0).toInt(), it.getBoolean(1)) }
                .function("bottles", 0) { it.target?.bottles }
                .function("maximumBottles", 0) { it.target?.maximumBottles }
        }
    }
}
