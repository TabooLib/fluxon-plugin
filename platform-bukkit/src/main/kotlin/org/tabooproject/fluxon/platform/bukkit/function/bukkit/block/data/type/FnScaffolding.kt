package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Scaffolding
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnScaffolding {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Scaffolding::class.java)
                .function("isBottom", 0) { it.target?.isBottom }
                .function("setBottom", 1) { it.target?.setBottom(it.getBoolean(0)) }
                .function("distance", 0) { it.target?.distance }
                .function("setDistance", 1) { it.target?.setDistance(it.getNumber(0).toInt()) }
                .function("maximumDistance", 0) { it.target?.maximumDistance }
        }
    }
}
