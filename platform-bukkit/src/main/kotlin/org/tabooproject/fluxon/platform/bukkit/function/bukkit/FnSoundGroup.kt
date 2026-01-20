package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.SoundGroup
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSoundGroup {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SoundGroup::class.java)
                .function("volume", 0) { it.target?.volume }
                .function("pitch", 0) { it.target?.pitch }
                .function("breakSound", 0) { it.target?.breakSound }
                .function("stepSound", 0) { it.target?.stepSound }
                .function("placeSound", 0) { it.target?.placeSound }
                .function("hitSound", 0) { it.target?.hitSound }
                .function("fallSound", 0) { it.target?.fallSound }
        }
    }
}
