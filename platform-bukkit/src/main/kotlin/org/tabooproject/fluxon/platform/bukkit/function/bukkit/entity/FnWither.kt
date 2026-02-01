package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Wither
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

@Requires(classes = ["org.bukkit.entity.Wither"])
@PlatformSide(Platform.BUKKIT)
object FnWither {

    val TYPE = Type.fromClass(Wither::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wither::class.java)
                .function("setTarget", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setTarget(it.getRef(0) as LivingEntity)
                }
                .function("setTarget", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setTarget(
                        it.getRef(0) as Wither.Head,
                        it.getRef(1) as LivingEntity
                    )
                }
                .function("getTarget", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getTarget(it.getRef(0) as Wither.Head)) }
                .function("invulnerabilityTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.invulnerabilityTicks ?: 0) }
                .function("setInvulnerabilityTicks", returnsVoid().params(Type.I)) { it.target?.setInvulnerabilityTicks(it.getInt(0).toInt()) }
        }
    }
}
