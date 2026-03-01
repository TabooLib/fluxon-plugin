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
//                .function("reviveHealth",returns(Type.D).noParams()) { it.setReturnRef(it.target?.reviveHealth) }
//                .function("setReviveHealth",returns(Type.OBJECT).params(Type.D)) { it.setReturnRef(it.target?reviveHealth = it.getDouble(0)) }
                .function("killer", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.entity?.killer) }
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("damageSource",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage.FnDamageSource.TYPE).noParams()) { it.setReturnRef(it.target?.damageSource) }
                .function("droppedExp", returns(Type.I).noParams()) { it.setReturnInt(it.target?.droppedExp ?: 0) }
                .function("setDroppedExp", returnsVoid().params(Type.I)) { it.target?.setDroppedExp(it.getInt(0).toInt()) }
                .function("drops",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.drops) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityDeathEvent.getHandlerList()) }
        }
    }
}
