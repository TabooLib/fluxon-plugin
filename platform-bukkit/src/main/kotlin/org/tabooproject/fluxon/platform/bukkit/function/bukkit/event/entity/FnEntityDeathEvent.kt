package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDeathEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.event.entity.EntityDeathEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityDeathEvent {

    val TYPE = Type.fromClass(EntityDeathEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDeathEvent::class.java)
//                .function("reviveHealth", returnsObject().noParams()) { it.setReturnRef(it.target?.reviveHealth) }
//                .function("setReviveHealth", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?reviveHealth = it.getDouble(0)) }
                .function("killer", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("damageSource", returnsObject().noParams()) { it.setReturnRef(it.target?.damageSource) }
                .function("droppedExp", returns(Type.I).noParams()) { it.setReturnInt(it.target?.droppedExp ?: 0) }
                .function("setDroppedExp", returnsVoid().params(Type.I)) { it.target?.setDroppedExp(it.getInt(0).toInt()) }
                .function("drops", returnsObject().noParams()) { it.setReturnRef(it.target?.drops) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(EntityDeathEvent.getHandlerList()) }
        }
    }
}
