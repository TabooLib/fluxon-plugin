package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Wither
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Wither"])
@PlatformSide(Platform.BUKKIT)
object FnWither {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wither::class.java)
                .function("setTarget", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setTarget(it.getRef(0) as LivingEntity)
                    } else {
                        it.target?.setTarget(
                            it.getRef(0) as Wither.Head,
                            it.getRef(1) as LivingEntity
                        )
                    }
                }
                .function("setTarget", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setTarget(it.getRef(0) as LivingEntity)
                    } else {
                        it.target?.setTarget(
                            it.getRef(0) as Wither.Head,
                            it.getRef(1) as LivingEntity
                        )
                    }
                }
                .function("getTarget", returnsObject().params(Type.OBJECT)) { it.target?.getTarget(it.getRef(0) as Wither.Head) }
                .function("invulnerabilityTicks", returnsObject().noParams()) { it.target?.invulnerabilityTicks }
                .function("setInvulnerabilityTicks", returnsObject().params(Type.OBJECT)) { it.target?.setInvulnerabilityTicks(it.getInt(0).toInt()) }
        }
    }
}
