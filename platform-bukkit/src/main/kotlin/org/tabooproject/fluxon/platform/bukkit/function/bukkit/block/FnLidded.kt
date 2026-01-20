package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Lidded
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLidded {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lidded::class.java)
                .function("open", 0) { it.target?.open() }
                .function("close", 0) { it.target?.close() }
        }
    }
}
