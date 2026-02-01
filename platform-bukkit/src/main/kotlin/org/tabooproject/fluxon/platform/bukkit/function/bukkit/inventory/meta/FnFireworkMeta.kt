package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.FireworkEffect
import org.bukkit.inventory.meta.FireworkMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.FireworkMeta"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkMeta {

    val TYPE = Type.fromClass(FireworkMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkMeta::class.java)
                .function("addEffect", returnsVoid().params(Type.OBJECT)) { it.target?.addEffect(it.getRef(0) as FireworkEffect) }
                .function("addEffects", returnsVoid().params(Type.OBJECT)) {
                    val effects = it.getRef(0)
                    if (effects is Iterable<*>) {
                        it.target?.addEffects(effects as Iterable<FireworkEffect>)
                    } else {
                        it.target?.addEffects(*(effects as Array<FireworkEffect>))
                    }
                }
                .function("effects", returnsObject().noParams()) { it.setReturnRef(it.target?.effects) }
                .function("effectsSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.effectsSize ?: 0) }
                .function("removeEffect", returnsVoid().params(Type.I)) { it.target?.removeEffect(it.getInt(0).toInt()) }
                .function("clearEffects", returnsVoid().noParams()) { it.target?.clearEffects() }
                .function("hasEffects", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasEffects() ?: false) }
                .function("power", returns(Type.I).noParams()) { it.setReturnInt(it.target?.power ?: 0) }
                .function("setPower", returnsVoid().params(Type.I)) { it.target?.setPower(it.getInt(0).toInt()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
