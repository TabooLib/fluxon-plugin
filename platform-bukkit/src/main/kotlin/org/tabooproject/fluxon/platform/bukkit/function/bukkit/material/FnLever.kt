package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Lever
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLever {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lever::class.java)
                .function("isPowered", 0) { it.target?.isPowered }
                .function("setPowered", 1) { it.target?.setPowered(it.getBoolean(0)) }
                .function("attachedFace", 0) { it.target?.attachedFace }
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
