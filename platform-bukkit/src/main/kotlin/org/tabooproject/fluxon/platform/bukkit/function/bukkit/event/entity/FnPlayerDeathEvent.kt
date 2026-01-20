package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.PlayerDeathEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerDeathEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerDeathEvent::class.java)
                .function("entity", 0) { it.target?.getEntity() }
                .function("setDeathMessage", 1) { it.target?.setDeathMessage(it.getString(0)) }
                .function("deathMessage", 0) { it.target?.deathMessage }
                .function("newExp", 0) { it.target?.newExp }
                .function("setNewExp", 1) { it.target?.setNewExp(it.getNumber(0).toInt()) }
                .function("newLevel", 0) { it.target?.newLevel }
                .function("setNewLevel", 1) { it.target?.setNewLevel(it.getNumber(0).toInt()) }
                .function("newTotalExp", 0) { it.target?.newTotalExp }
                .function("setNewTotalExp", 1) { it.target?.setNewTotalExp(it.getNumber(0).toInt()) }
                .function("keepLevel", 0) { it.target?.keepLevel }
                .function("setKeepLevel", 1) { it.target?.setKeepLevel(it.getBoolean(0)) }
                .function("setKeepInventory", 1) { it.target?.setKeepInventory(it.getBoolean(0)) }
                .function("keepInventory", 0) { it.target?.keepInventory }
        }
    }
}
