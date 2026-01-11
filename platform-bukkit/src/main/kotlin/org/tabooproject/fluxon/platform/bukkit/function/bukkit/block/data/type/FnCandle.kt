package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Candle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCandle {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Candle::class.java)
                .function("candles", 0) { it.target?.candles }
                .function("setCandles", 1) { it.target?.setCandles(it.getNumber(0).toInt()) }
                .function("maximumCandles", 0) { it.target?.maximumCandles }
        }
    }
}
