package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.EnderSignal
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEnderSignal {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderSignal::class.java)
                .function("targetLocation", 0) { it.target?.targetLocation }
                .function("setTargetLocation", 1) { it.target?.setTargetLocation(it.getArgument(0) as Location) }
                .function("dropItem", 0) { it.target?.dropItem }
                .function("setDropItem", 1) { it.target?.setDropItem(it.getBoolean(0)) }
                .function("item", 0) { it.target?.item }
                .function("setItem", 1) { it.target?.setItem(it.getArgument(0) as ItemStack) }
                .function("despawnTimer", 0) { it.target?.despawnTimer }
                .function("setDespawnTimer", 1) { it.target?.setDespawnTimer(it.getNumber(0).toInt()) }
        }
    }
}
