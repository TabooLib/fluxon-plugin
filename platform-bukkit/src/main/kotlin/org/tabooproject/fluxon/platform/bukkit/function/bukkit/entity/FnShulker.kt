package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.BlockFace
import org.bukkit.entity.Shulker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnShulker {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Shulker::class.java)
                .function("peek", 0) { it.target?.peek }
                .function("setPeek", 1) { it.target?.setPeek(it.getNumber(0).toFloat()) }
                .function("attachedFace", 0) { it.target?.attachedFace }
                .function("setAttachedFace", 1) { it.target?.setAttachedFace(it.getArgument(0) as BlockFace) }
        }
    }
}
