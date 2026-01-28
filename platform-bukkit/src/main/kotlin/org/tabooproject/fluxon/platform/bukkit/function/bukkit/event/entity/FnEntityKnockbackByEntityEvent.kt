package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityKnockbackByEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.entity.EntityKnockbackByEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityKnockbackByEntityEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityKnockbackByEntityEvent::class.java)
                .function("sourceEntity", returnsObject().noParams()) { it.setReturnRef(it.target?.sourceEntity) }
        }
    }
}
