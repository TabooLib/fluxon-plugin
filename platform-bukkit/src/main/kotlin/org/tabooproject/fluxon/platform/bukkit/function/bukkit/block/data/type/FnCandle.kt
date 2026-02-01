package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Candle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Candle"])
@PlatformSide(Platform.BUKKIT)
object FnCandle {

    val TYPE = Type.fromClass(Candle::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Candle::class.java)
                .function("candles", returns(Type.I).noParams()) { it.setReturnInt(it.target?.candles ?: 0) }
                .function("setCandles", returnsVoid().params(Type.I)) { it.target?.setCandles(it.getInt(0)) }
                .function("maximumCandles", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumCandles ?: 0) }
        }
    }
}
