package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.StructureBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnStructureBlock {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureBlock::class.java)
                .function("mode", 0) { it.target?.mode }
                .function("setMode", 1) { it.target?.setMode(it.getArgument(0) as StructureBlock.Mode) }
        }
    }
}
