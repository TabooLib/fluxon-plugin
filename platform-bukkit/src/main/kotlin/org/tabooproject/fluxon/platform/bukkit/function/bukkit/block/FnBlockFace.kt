package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires


@Requires(classes = ["org.bukkit.block.BlockFace"])
@PlatformSide(Platform.BUKKIT)
object FnBlockFace {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockFace::class.java)
                // 橙汁喵: 枚举类语法
                .function("name", 0) { it.target?.name }
                // 橙汁喵: 枚举类语法
                .function("ordinal", 0) { it.target?.ordinal }
                .function("modX", 0) { it.target?.modX }
                .function("modY", 0) { it.target?.modY }
                .function("modZ", 0) { it.target?.modZ }
                .function("direction", 0) { it.target?.direction }
                .function("isCartesian", 0) { it.target?.isCartesian }
                .function("oppositeFace", 0) { it.target?.oppositeFace }
        }
    }
}
