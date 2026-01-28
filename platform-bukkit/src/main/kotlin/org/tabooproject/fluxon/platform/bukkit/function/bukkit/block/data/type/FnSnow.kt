package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Snow
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Snow"])
@PlatformSide(Platform.BUKKIT)
object FnSnow {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Snow::class.java)
                .function("layers", returnsObject().noParams()) { it.setReturnRef(it.target?.layers) }
                .function("setLayers", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLayers(it.getInt(0).toInt())) }
                .function("minimumLayers", returnsObject().noParams()) { it.setReturnRef(it.target?.minimumLayers) }
                .function("maximumLayers", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumLayers) }
        }
    }
}
