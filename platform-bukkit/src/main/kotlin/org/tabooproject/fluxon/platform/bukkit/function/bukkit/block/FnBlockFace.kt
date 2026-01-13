package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnBlockFace {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockFace::class.java)
                .function("name", 0) { it.target?.name }
                .function("direction", 0) { it.target?.direction }
                .function("modX", 0) { it.target?.modX }
                .function("modY", 0) { it.target?.modY }
                .function("modZ", 0) { it.target?.modZ }
                .function("oppositeFace", 0) { it.target?.oppositeFace }
                .function("isCartesian", 0) { it.target?.isCartesian }
        }
    }
}
