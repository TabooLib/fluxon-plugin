package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Husk
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnHusk {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Husk::class.java)
                .function("isConverting", 0) { it.target?.isConverting }
                .function("conversionTime", 0) { it.target?.conversionTime }
                .function("setConversionTime", 1) { it.target?.setConversionTime(it.getNumber(0).toInt()) }
        }
    }
}
