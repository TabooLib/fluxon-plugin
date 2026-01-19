package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.meta.OminousBottleMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnOminousBottleMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OminousBottleMeta::class.java)
                .function("hasAmplifier", 0) { it.target?.hasAmplifier() }
                .function("amplifier", 0) { it.target?.amplifier }
                .function("setAmplifier", 1) { it.target?.setAmplifier(it.getNumber(0).toInt()) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
