package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.PointedDripstone
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.type.PointedDripstone"])
@PlatformSide(Platform.BUKKIT)
object FnPointedDripstone {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PointedDripstone::class.java)
                .function("verticalDirection", 0) { it.target?.verticalDirection }
                .function("setVerticalDirection", 1) { it.target?.setVerticalDirection(it.getArgument(0) as BlockFace) }
                .function("verticalDirections", 0) { it.target?.verticalDirections }
                .function("thickness", 0) { it.target?.thickness }
                .function(
                    "setThickness",
                    1
                ) { it.target?.setThickness(it.getArgument(0) as PointedDripstone.Thickness) }
        }
    }
}
