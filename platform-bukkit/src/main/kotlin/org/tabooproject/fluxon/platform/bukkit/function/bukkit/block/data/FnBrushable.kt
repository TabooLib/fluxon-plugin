package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Brushable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Brushable"])
@PlatformSide(Platform.BUKKIT)
object FnBrushable {

    val TYPE = Type.fromClass(Brushable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Brushable::class.java)
                .function("dusted", returns(Type.I).noParams()) { it.setReturnInt(it.target?.dusted ?: 0) }
                .function("setDusted", returnsVoid().params(Type.I)) { it.target?.setDusted(it.getInt(0)) }
                .function("maximumDusted", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumDusted ?: 0) }
        }
    }
}
