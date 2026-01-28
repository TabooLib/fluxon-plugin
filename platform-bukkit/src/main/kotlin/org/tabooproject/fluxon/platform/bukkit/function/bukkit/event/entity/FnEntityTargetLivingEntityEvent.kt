package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.entity.Entity
import org.bukkit.event.entity.EntityTargetLivingEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.entity.EntityTargetLivingEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityTargetLivingEntityEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityTargetLivingEntityEvent::class.java)
                .function("target", returnsObject().noParams()) { it.setReturnRef(it.target?.target) }
                .function("setTarget", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTarget(it.getRef(0) as Entity)) }
        }
    }
}
