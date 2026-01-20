package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.OminousItemSpawner
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnOminousItemSpawner {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OminousItemSpawner::class.java)
                .function("item", 0) { it.target?.item }
                .function("setItem", 1) { it.target?.setItem(it.getArgument(0) as ItemStack) }
                .function("spawnItemAfterTicks", 0) { it.target?.spawnItemAfterTicks }
                .function("setSpawnItemAfterTicks", 1) { it.target?.setSpawnItemAfterTicks(it.getNumber(0).toLong()) }
        }
    }
}
