package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.Wall
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWall {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wall::class.java)
                .function("isUp", 0) { it.target?.isUp }
                .function("setUp", 1) { it.target?.setUp(it.getBoolean(0)) }
                .function("height", 1) { it.target?.getHeight(it.getArgument(0) as BlockFace) }
                .function("setHeight", 2) {
                    it.target?.setHeight(
                        it.getArgument(0) as BlockFace,
                        it.getArgument(1) as Wall.Height
                    )
                }
        }
    }
}
