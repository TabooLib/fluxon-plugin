package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Villager
import org.bukkit.entity.Zombie
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnZombie {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Zombie::class.java)
                .function("isBaby", 0) { it.target?.isBaby }
                .function("setBaby", 1) { it.target?.setBaby(it.getBoolean(0)) }
                .function("isVillager", 0) { it.target?.isVillager }
                .function("setVillager", 1) { it.target?.setVillager(it.getBoolean(0)) }
                .function(
                    "setVillagerProfession",
                    1
                ) { it.target?.setVillagerProfession(it.getArgument(0) as Villager.Profession) }
                .function("isConverting", 0) { it.target?.isConverting }
                .function("conversionTime", 0) { it.target?.conversionTime }
                .function("setConversionTime", 1) { it.target?.setConversionTime(it.getNumber(0).toInt()) }
                .function("canBreakDoors", 0) { it.target?.canBreakDoors() }
                .function("setCanBreakDoors", 1) { it.target?.setCanBreakDoors(it.getBoolean(0)) }
        }
    }
}
