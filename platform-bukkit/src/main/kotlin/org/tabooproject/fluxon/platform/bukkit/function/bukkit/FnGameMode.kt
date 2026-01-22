package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.GameMode
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnGameMode {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GameMode::class.java)
                .function("value", 0) { it.target?.value }
                // static
                .function("getByValue", 1) { GameMode.getByValue(it.getNumber(0).toInt()) }
        }
    }
}
