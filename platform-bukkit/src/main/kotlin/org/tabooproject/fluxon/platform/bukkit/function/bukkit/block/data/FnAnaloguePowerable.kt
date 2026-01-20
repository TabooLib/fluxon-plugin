package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.AnaloguePowerable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAnaloguePowerable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AnaloguePowerable::class.java)
                .function("power", 0) { it.target?.power }
                .function("setPower", 1) { it.target?.setPower(it.getNumber(0).toInt()) }
                .function("maximumPower", 0) { it.target?.maximumPower }
        }
    }
}
