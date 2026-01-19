package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.DoubleChest
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnDoubleChest {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DoubleChest::class.java)
                .function("inventory", 0) { it.target?.inventory }
                .function("leftSide", 0) { it.target?.leftSide }
                .function("rightSide", 0) { it.target?.rightSide }
                .function("location", 0) { it.target?.location }
                .function("world", 0) { it.target?.world }
                .function("x", 0) { it.target?.x }
                .function("y", 0) { it.target?.y }
                .function("z", 0) { it.target?.z }
        }
    }
}
