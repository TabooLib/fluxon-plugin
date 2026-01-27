package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.BlockFace
import org.bukkit.block.data.Rotatable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.Rotatable"])
@PlatformSide(Platform.BUKKIT)
object FnRotatable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rotatable::class.java)
                .function("rotation", 0) { it.target?.rotation }
                .function("setRotation", 1) { it.target?.setRotation(it.getArgument(0) as BlockFace) }
        }
    }
}
