package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Slab
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSlab {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Slab::class.java)
                .function("type", 0) { it.target?.type }
                .function("setType", 1) { it.target?.setType(it.getArgument(0) as Slab.Type) }
        }
    }
}
