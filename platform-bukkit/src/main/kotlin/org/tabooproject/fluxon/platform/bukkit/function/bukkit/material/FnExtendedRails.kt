package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.ExtendedRails
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnExtendedRails {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExtendedRails::class.java)
                .function("isCurve", 0) { it.target?.isCurve }
                .function("setDirection", 2) {
                    it.target?.setDirection(
                        it.getArgument(0) as BlockFace,
                        it.getBoolean(1)
                    )
                }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
