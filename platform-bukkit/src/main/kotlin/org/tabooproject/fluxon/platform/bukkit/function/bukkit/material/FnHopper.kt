package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Hopper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.Hopper"])
@PlatformSide(Platform.BUKKIT)
object FnHopper {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hopper::class.java)
                .function("setActive", 1) { it.target?.setActive(it.getBoolean(0)) }
                .function("isActive", 0) { it.target?.isActive }
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("facing", 0) { it.target?.facing }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
                .function("isPowered", 0) { it.target?.isPowered }
        }
    }
}
