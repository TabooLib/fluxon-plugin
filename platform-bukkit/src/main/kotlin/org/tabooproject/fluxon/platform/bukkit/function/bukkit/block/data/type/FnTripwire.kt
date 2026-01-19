package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Tripwire
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnTripwire {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tripwire::class.java)
                .function("isDisarmed", 0) { it.target?.isDisarmed }
                .function("setDisarmed", 1) { it.target?.setDisarmed(it.getBoolean(0)) }
        }
    }
}
