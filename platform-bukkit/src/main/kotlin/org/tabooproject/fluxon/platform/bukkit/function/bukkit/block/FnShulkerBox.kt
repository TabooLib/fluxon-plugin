package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.ShulkerBox
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnShulkerBox {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShulkerBox::class.java)
                .function("color", 0) { it.target?.color }
        }
    }
}
