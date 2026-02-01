package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.event.entity.EntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityEvent {

    val TYPE = Type.fromClass(EntityEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("entityType", returnsObject().noParams()) { it.setReturnRef(it.target?.entityType) }
        }
    }
}
