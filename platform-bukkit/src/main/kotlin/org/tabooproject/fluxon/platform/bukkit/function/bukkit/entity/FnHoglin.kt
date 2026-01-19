package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Hoglin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnHoglin {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hoglin::class.java)
                .function("isImmuneToZombification", 0) { it.target?.isImmuneToZombification }
                .function("setImmuneToZombification", 1) { it.target?.setImmuneToZombification(it.getBoolean(0)) }
                .function("isAbleToBeHunted", 0) { it.target?.isAbleToBeHunted }
                .function("setIsAbleToBeHunted", 1) { it.target?.setIsAbleToBeHunted(it.getBoolean(0)) }
                .function("conversionTime", 0) { it.target?.conversionTime }
                .function("setConversionTime", 1) { it.target?.setConversionTime(it.getNumber(0).toInt()) }
                .function("isConverting", 0) { it.target?.isConverting }
        }
    }
}
