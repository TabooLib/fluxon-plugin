package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.FireworkEffect
import org.bukkit.inventory.meta.FireworkMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.FireworkMeta"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkMeta::class.java)
                .function("addEffect", returnsObject().params(Type.OBJECT)) { it.target?.addEffect(it.getRef(0) as FireworkEffect) }
                .function("addEffects", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.addEffects()
                    } else {
                        it.target?.addEffects(it.getRef(0) as Iterable<FireworkEffect>)
                    }
                }
                .function("addEffects", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.addEffects()
                    } else {
                        it.target?.addEffects(it.getRef(0) as Iterable<FireworkEffect>)
                    }
                }
                .function("effects", returnsObject().noParams()) { it.target?.effects }
                .function("effectsSize", returnsObject().noParams()) { it.target?.effectsSize }
                .function("removeEffect", returnsObject().params(Type.OBJECT)) { it.target?.removeEffect(it.getInt(0).toInt()) }
                .function("clearEffects", returnsObject().noParams()) { it.target?.clearEffects() }
                .function("hasEffects", returns(Type.Z).noParams()) { it.target?.hasEffects() }
                .function("power", returnsObject().noParams()) { it.target?.power }
                .function("setPower", returnsObject().params(Type.OBJECT)) { it.target?.setPower(it.getInt(0).toInt()) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
