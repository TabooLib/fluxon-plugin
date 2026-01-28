package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.FireworkEffect
import org.bukkit.inventory.meta.FireworkEffectMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.FireworkEffectMeta"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkEffectMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkEffectMeta::class.java)
                .function("setEffect", returnsObject().params(Type.OBJECT)) { it.target?.setEffect(it.getRef(0) as FireworkEffect) }
                .function("hasEffect", returns(Type.Z).noParams()) { it.target?.hasEffect() }
                .function("effect", returnsObject().noParams()) { it.target?.effect }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
