package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Beehive
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBeehive {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Beehive::class.java)
                .function("honeyLevel", 0) { it.target?.honeyLevel }
                .function("setHoneyLevel", 1) { it.target?.setHoneyLevel(it.getNumber(0).toInt()) }
                .function("maximumHoneyLevel", 0) { it.target?.maximumHoneyLevel }
        }
    }
}
