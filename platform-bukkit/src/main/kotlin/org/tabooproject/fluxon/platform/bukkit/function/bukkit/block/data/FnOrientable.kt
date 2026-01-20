package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.Axis
import org.bukkit.block.data.Orientable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnOrientable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Orientable::class.java)
                .function("axis", 0) { it.target?.axis }
                .function("setAxis", 1) { it.target?.setAxis(it.getArgument(0) as Axis) }
                .function("axes", 0) { it.target?.axes }
        }
    }
}
