package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.RespawnAnchor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnRespawnAnchor {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RespawnAnchor::class.java)
                .function("charges", 0) { it.target?.charges }
                .function("setCharges", 1) { it.target?.setCharges(it.getNumber(0).toInt()) }
                .function("maximumCharges", 0) { it.target?.maximumCharges }
        }
    }
}
