package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.CocoaPlant
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.CocoaPlant"])
@PlatformSide(Platform.BUKKIT)
object FnCocoaPlant {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CocoaPlant::class.java)
                .function("size", 0) { it.target?.size }
                .function("setSize", 1) { it.target?.setSize(it.getArgument(0) as CocoaPlant.CocoaPlantSize) }
                .function("attachedFace", 0) { it.target?.attachedFace }
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("facing", 0) { it.target?.facing }
                .function("clone", 0) { it.target?.clone() }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
