package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Hopper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnHopper {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hopper::class.java)
                .function("isEnabled", 0) { it.target?.isEnabled }
                .function("setEnabled", 1) { it.target?.setEnabled(it.getBoolean(0)) }
        }
    }
}
