package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.MusicInstrument
import org.bukkit.inventory.meta.MusicInstrumentMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMusicInstrumentMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MusicInstrumentMeta::class.java)
                .function("setInstrument", 1) { it.target?.setInstrument(it.getArgument(0) as MusicInstrument) }
                .function("instrument", 0) { it.target?.instrument }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
