package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.FireworkEffect
import org.bukkit.inventory.meta.FireworkEffectMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.FireworkEffectMeta"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkEffectMeta {

    val TYPE = Type.fromClass(FireworkEffectMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkEffectMeta::class.java)
                .function("setEffect",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffect.TYPE)) { it.target?.setEffect(it.getRef(0) as FireworkEffect) }
                .function("hasEffect", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasEffect() ?: false) }
                .function("effect", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFireworkEffect.TYPE).noParams()) { it.setReturnRef(it.target?.effect) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnFireworkEffectMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
