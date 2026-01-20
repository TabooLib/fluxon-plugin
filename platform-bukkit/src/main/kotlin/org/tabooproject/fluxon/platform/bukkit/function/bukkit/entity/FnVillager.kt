package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Villager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnVillager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Villager::class.java)
                .function("profession", 0) { it.target?.profession }
                .function("setProfession", 1) { it.target?.setProfession(it.getArgument(0) as Villager.Profession) }
                .function("villagerType", 0) { it.target?.villagerType }
                .function("setVillagerType", 1) { it.target?.setVillagerType(it.getArgument(0) as Villager.Type) }
                .function("villagerLevel", 0) { it.target?.villagerLevel }
                .function("setVillagerLevel", 1) { it.target?.setVillagerLevel(it.getNumber(0).toInt()) }
                .function("villagerExperience", 0) { it.target?.villagerExperience }
                .function("setVillagerExperience", 1) { it.target?.setVillagerExperience(it.getNumber(0).toInt()) }
                .function("sleep", 1) { it.target?.sleep(it.getArgument(0) as Location) }
                .function("wakeup", 0) { it.target?.wakeup() }
                .function("shakeHead", 0) { it.target?.shakeHead() }
                .function("zombify", 0) { it.target?.zombify() }

            registerExtension(Villager.Type::class.java)
                .function("key", 0) { it.target?.key }

            registerExtension(Villager.Profession::class.java)
                .function("key", 0) { it.target?.key }
        }
    }
}
