package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Rails
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.Rails"])
@PlatformSide(Platform.BUKKIT)
object FnRails {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rails::class.java)
                .function("isOnSlope", 0) { it.target?.isOnSlope }
                .function("isCurve", 0) { it.target?.isCurve }
                .function("direction", 0) { it.target?.direction }
                .function("toString", 0) { it.target?.toString() }
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
