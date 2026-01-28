package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Llama
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Llama"])
@PlatformSide(Platform.BUKKIT)
object FnLlama {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Llama::class.java)
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setColor(it.getRef(0) as Llama.Color)) }
                .function("strength", returnsObject().noParams()) { it.setReturnRef(it.target?.strength) }
                .function("setStrength", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setStrength(it.getInt(0).toInt())) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
