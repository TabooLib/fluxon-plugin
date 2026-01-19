package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Diode
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnDiode {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Diode::class.java)
                .function("setDelay", 1) { it.target?.setDelay(it.getNumber(0).toInt()) }
                .function("delay", 0) { it.target?.delay }
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("facing", 0) { it.target?.facing }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
                .function("isPowered", 0) { it.target?.isPowered }
        }
    }
}
