package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.BigDripleaf
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBigDripleaf {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BigDripleaf::class.java)
                .function("tilt", 0) { it.target?.tilt }
                .function("setTilt", 1) { it.target?.setTilt(it.getArgument(0) as BigDripleaf.Tilt) }
        }
    }
}
