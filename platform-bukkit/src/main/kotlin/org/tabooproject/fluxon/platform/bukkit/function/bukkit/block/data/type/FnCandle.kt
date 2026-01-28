package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Candle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Candle"])
@PlatformSide(Platform.BUKKIT)
object FnCandle {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Candle::class.java)
                .function("candles", returnsObject().noParams()) { it.setReturnRef(it.target?.candles) }
                .function("setCandles", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCandles(it.getInt(0).toInt())) }
                .function("maximumCandles", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumCandles) }
        }
    }
}
