package org.tabooproject.fluxon.platform.bukkit.function.world

import org.bukkit.block.Block
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FunctionBlock {

    @Awake(LifeCycle.LOAD)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Block::class.java)
                .function("type", 0) {
                    it.target?.type
                }
                .function("x", 0) {
                    it.target?.x
                }
                .function("y", 0) {
                    it.target?.y
                }
                .function("z", 0) {
                    it.target?.z
                }
        }
    }
}