package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.FoodLevelChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFoodLevelChangeEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FoodLevelChangeEvent::class.java)
                .function("entity", 0) { it.target?.entity }
                .function("item", 0) { it.target?.item }
                .function("foodLevel", 0) { it.target?.foodLevel }
                .syncFunction("setFoodLevel", 1) { it.target?.apply { foodLevel = it.getNumber(0).toInt() } }
        }
    }
}
