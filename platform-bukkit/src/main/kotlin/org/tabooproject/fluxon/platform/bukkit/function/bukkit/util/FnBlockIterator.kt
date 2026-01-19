package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.BlockIterator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockIterator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockIterator::class.java)
                .function("hasNext", 0) { it.target?.hasNext() }
                .function("next", 0) { it.target?.next() }
                .function("remove", 0) { it.target?.remove() }
        }
    }
}
