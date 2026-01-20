package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Banner
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBanner {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Banner::class.java)
                .function("isWallBanner", 0) { it.target?.isWallBanner }
                .function("attachedFace", 0) { it.target?.attachedFace }
                .function("facing", 0) { it.target?.facing }
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
