package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Llama
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

@Requires(classes = ["org.bukkit.entity.Llama"])
@PlatformSide(Platform.BUKKIT)
object FnLlama {

    val TYPE = Type.fromClass(Llama::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Llama::class.java)
                .function("color", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLlamaColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLlamaColor.TYPE)) { it.target?.setColor(it.getRef(0) as Llama.Color)  }
                .function("setColor", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLlamaColor.enumValue(it.getString(0))?.let { p0 -> it.target?.setColor(p0)  } }
                .function("strength", returns(Type.I).noParams()) { it.setReturnInt(it.target?.strength ?: 0) }
                .function("setStrength", returnsVoid().params(Type.I)) { it.target?.setStrength(it.getInt(0).toInt()) }
                .function("inventory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
