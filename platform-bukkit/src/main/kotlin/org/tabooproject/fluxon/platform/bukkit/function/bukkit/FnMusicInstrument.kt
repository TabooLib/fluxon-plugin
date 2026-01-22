package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.MusicInstrument
import org.bukkit.NamespacedKey
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMusicInstrument {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MusicInstrument::class.java)
                // static
                .function("getByKey", 1) { MusicInstrument.getByKey(it.getArgument(0) as NamespacedKey) }
                // static
                .function("values", 0) { MusicInstrument.values() }
        }
    }
}
