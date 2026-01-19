package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDeathEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnEntityDeathEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDeathEvent::class.java)
//                .function("reviveHealth", 0) { it.target?.reviveHealth }
//                .function("setReviveHealth", 1) { it.target?reviveHealth = it.getNumber(0).toDouble() }
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .function("killer", 0) { it.target?.getEntity() }
                .function("entity", 0) { it.target?.getEntity() }
                .function("damageSource", 0) { it.target?.damageSource }
                .function("droppedExp", 0) { it.target?.droppedExp }
                .function("setDroppedExp", 1) { it.target?.setDroppedExp(it.getNumber(0).toInt()) }
                .function("drops", 0) { it.target?.drops }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { EntityDeathEvent.getHandlerList() }
        }
    }
}
