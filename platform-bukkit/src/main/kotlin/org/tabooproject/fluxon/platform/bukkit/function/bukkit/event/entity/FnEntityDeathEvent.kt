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
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDeathEvent::class.java)
//                .function("reviveHealth", 0) { it.target?.reviveHealth }
//                .syncFunction("setReviveHealth", 1) { it.target?.apply { reviveHealth = it.getNumber(0).toDouble() } }
                .function("droppedExp", 0) { it.target?.droppedExp }
                .syncFunction("setDroppedExp", 1) { it.target?.apply { droppedExp = it.getNumber(0).toInt() } }
                .function("drops", 0) { it.target?.drops }
                .function("killer", 0) { it.target?.entity?.killer }
        }
    }
}
