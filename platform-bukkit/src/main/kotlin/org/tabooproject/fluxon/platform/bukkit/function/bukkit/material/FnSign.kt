package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Sign
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSign {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sign::class.java)
                .function("isWallSign", 0) { it.target?.isWallSign }
                .function("attachedFace", 0) { it.target?.attachedFace }
                .function("facing", 0) { it.target?.facing }
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
