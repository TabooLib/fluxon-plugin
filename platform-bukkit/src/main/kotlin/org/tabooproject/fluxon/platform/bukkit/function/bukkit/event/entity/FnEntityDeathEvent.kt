package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDeathEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.event.entity.EntityDeathEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityDeathEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDeathEvent::class.java)
//                .function("reviveHealth", returnsObject().noParams()) { it.target?.reviveHealth }
//                .function("setReviveHealth", returnsObject().params(Type.OBJECT)) { it.target?reviveHealth = it.getAsDouble(0) }
                .function("killer", returnsObject().noParams()) { it.target?.getEntity() }
                .function("entity", returnsObject().noParams()) { it.target?.getEntity() }
                .function("damageSource", returnsObject().noParams()) { it.target?.damageSource }
                .function("droppedExp", returnsObject().noParams()) { it.target?.droppedExp }
                .function("setDroppedExp", returnsObject().params(Type.OBJECT)) { it.target?.setDroppedExp(it.getInt(0).toInt()) }
                .function("drops", returnsObject().noParams()) { it.target?.drops }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { EntityDeathEvent.getHandlerList() }
        }
    }
}
