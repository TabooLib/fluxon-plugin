package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Farmland
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.type.Farmland"])
@PlatformSide(Platform.BUKKIT)
object FnFarmland {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Farmland::class.java)
                .function("moisture", 0) { it.target?.moisture }
                .function("setMoisture", 1) { it.target?.setMoisture(it.getNumber(0).toInt()) }
                .function("maximumMoisture", 0) { it.target?.maximumMoisture }
        }
    }
}
