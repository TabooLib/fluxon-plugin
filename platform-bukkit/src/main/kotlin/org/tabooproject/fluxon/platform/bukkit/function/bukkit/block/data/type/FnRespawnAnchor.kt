package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.RespawnAnchor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.RespawnAnchor"])
@PlatformSide(Platform.BUKKIT)
object FnRespawnAnchor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RespawnAnchor::class.java)
                .function("charges", returnsObject().noParams()) { it.setReturnRef(it.target?.charges) }
                .function("setCharges", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCharges(it.getInt(0).toInt())) }
                .function("maximumCharges", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumCharges) }
        }
    }
}
