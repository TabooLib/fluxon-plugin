package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Repeater
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.type.Repeater"])
@PlatformSide(Platform.BUKKIT)
object FnRepeater {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Repeater::class.java)
                .function("delay", 0) { it.target?.delay }
                .function("setDelay", 1) { it.target?.setDelay(it.getNumber(0).toInt()) }
                .function("minimumDelay", 0) { it.target?.minimumDelay }
                .function("maximumDelay", 0) { it.target?.maximumDelay }
                .function("isLocked", 0) { it.target?.isLocked }
                .function("setLocked", 1) { it.target?.setLocked(it.getBoolean(0)) }
        }
    }
}
