package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.PigZombie
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPigZombie {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PigZombie::class.java)
                .function("anger", 0) { it.target?.anger }
                .function("setAnger", 1) { it.target?.setAnger(it.getNumber(0).toInt()) }
                .function("setAngry", 1) { it.target?.setAngry(it.getBoolean(0)) }
                .function("isAngry", 0) { it.target?.isAngry }
                .function("isConverting", 0) { it.target?.isConverting }
                .function("conversionTime", 0) { it.target?.conversionTime }
                .function("setConversionTime", 1) { it.target?.setConversionTime(it.getNumber(0).toInt()) }
        }
    }
}
