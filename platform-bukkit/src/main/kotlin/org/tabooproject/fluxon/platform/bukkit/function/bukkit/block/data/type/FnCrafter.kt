package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Crafter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCrafter {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Crafter::class.java)
                .function("isCrafting", 0) { it.target?.isCrafting }
                .function("setCrafting", 1) { it.target?.setCrafting(it.getBoolean(0)) }
                .function("isTriggered", 0) { it.target?.isTriggered }
                .function("setTriggered", 1) { it.target?.setTriggered(it.getBoolean(0)) }
                .function("orientation", 0) { it.target?.orientation }
                .function("setOrientation", 1) { it.target?.setOrientation(it.getArgument(0) as Crafter.Orientation) }
        }
    }
}
