package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Sound
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSound {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sound::class.java)
                .function("key", 0) { it.target?.key }
        }
    }
}
