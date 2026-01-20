package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Hatchable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnHatchable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hatchable::class.java)
                .function("hatch", 0) { it.target?.hatch }
                .function("setHatch", 1) { it.target?.setHatch(it.getNumber(0).toInt()) }
                .function("maximumHatch", 0) { it.target?.maximumHatch }
        }
    }
}
