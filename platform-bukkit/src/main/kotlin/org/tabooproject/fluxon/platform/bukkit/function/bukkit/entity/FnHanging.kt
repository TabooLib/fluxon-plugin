package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.BlockFace
import org.bukkit.entity.Hanging
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnHanging {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hanging::class.java)
                .function("setFacingDirection", 2) {
                    it.target?.setFacingDirection(
                        it.getArgument(0) as BlockFace,
                        it.getBoolean(1)
                    )
                }
        }
    }
}
