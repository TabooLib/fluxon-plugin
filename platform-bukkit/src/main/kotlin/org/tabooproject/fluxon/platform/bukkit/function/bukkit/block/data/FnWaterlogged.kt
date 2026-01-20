package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Waterlogged
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWaterlogged {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Waterlogged::class.java)
                .function("isWaterlogged", 0) { it.target?.isWaterlogged }
                .function("setWaterlogged", 1) { it.target?.setWaterlogged(it.getBoolean(0)) }
        }
    }
}
