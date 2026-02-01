package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Snow
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Snow"])
@PlatformSide(Platform.BUKKIT)
object FnSnow {

    val TYPE = Type.fromClass(Snow::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Snow::class.java)
                .function("layers", returns(Type.I).noParams()) { it.setReturnInt(it.target?.layers ?: 0) }
                .function("setLayers", returnsVoid().params(Type.I)) { it.target?.setLayers(it.getInt(0).toInt()) }
                .function("minimumLayers", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minimumLayers ?: 0) }
                .function("maximumLayers", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumLayers ?: 0) }
        }
    }
}
