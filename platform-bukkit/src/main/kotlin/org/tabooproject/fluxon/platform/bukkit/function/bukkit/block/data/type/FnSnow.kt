package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Snow
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSnow {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Snow::class.java)
                .function("layers", 0) { it.target?.layers }
                .function("setLayers", 1) { it.target?.setLayers(it.getNumber(0).toInt()) }
                .function("minimumLayers", 0) { it.target?.minimumLayers }
                .function("maximumLayers", 0) { it.target?.maximumLayers }
        }
    }
}
