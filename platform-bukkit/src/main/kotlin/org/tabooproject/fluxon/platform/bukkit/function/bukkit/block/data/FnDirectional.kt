package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.BlockFace
import org.bukkit.block.data.Directional
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.Directional"])
@PlatformSide(Platform.BUKKIT)
object FnDirectional {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Directional::class.java)
                .function("facing", 0) { it.target?.facing }
                .function("setFacing", 1) { it.target?.setFacing(it.getArgument(0) as BlockFace) }
                .function("faces", 0) { it.target?.faces }
        }
    }
}
