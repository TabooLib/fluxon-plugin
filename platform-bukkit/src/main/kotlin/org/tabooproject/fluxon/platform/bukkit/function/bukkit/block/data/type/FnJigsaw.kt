package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Jigsaw
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnJigsaw {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Jigsaw::class.java)
                .function("orientation", 0) { it.target?.orientation }
                .function("setOrientation", 1) { it.target?.setOrientation(it.getArgument(0) as Jigsaw.Orientation) }
        }
    }
}
