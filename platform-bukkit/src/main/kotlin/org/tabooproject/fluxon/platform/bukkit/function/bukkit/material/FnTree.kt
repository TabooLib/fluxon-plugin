package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Tree
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTree {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tree::class.java)
                .function("direction", 0) { it.target?.direction }
                .function("setDirection", 1) { it.target?.setDirection(it.getArgument(0) as BlockFace) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
