package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Instrument
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.Instrument"])
@PlatformSide(Platform.BUKKIT)
object FnInstrument {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Instrument::class.java)
                .function("sound", 0) { it.target?.sound }
                .function("type", 0) { it.target?.type }
                // static
                .function("getByType", 1) { Instrument.getByType(it.getNumber(0).toByte()) }
        }
    }
}
