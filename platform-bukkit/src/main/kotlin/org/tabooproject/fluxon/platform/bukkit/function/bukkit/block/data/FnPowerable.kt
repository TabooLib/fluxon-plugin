package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Powerable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPowerable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Powerable::class.java)
                .function("isPowered", 0) { it.target?.isPowered }
                .function("setPowered", 1) { it.target?.setPowered(it.getBoolean(0)) }
        }
    }
}
