package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.OfflinePlayer
import org.bukkit.entity.Villager
import org.bukkit.entity.ZombieVillager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnZombieVillager {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ZombieVillager::class.java)
                .function(
                    "setVillagerProfession",
                    1
                ) { it.target?.setVillagerProfession(it.getArgument(0) as Villager.Profession) }
                .function("setVillagerType", 1) { it.target?.setVillagerType(it.getArgument(0) as Villager.Type) }
                .function("isConverting", 0) { it.target?.isConverting }
                .function("conversionTime", 0) { it.target?.conversionTime }
                .function("setConversionTime", 1) { it.target?.setConversionTime(it.getNumber(0).toInt()) }
                .function("conversionPlayer", 0) { it.target?.conversionPlayer }
                .function(
                    "setConversionPlayer",
                    1
                ) { it.target?.setConversionPlayer(it.getArgument(0) as OfflinePlayer) }
        }
    }
}
