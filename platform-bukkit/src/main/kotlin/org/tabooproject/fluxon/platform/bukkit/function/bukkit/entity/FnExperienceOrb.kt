package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ExperienceOrb
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnExperienceOrb {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExperienceOrb::class.java)
                .function("experience", 0) { it.target?.experience }
                .function("setExperience", 1) { it.target?.setExperience(it.getNumber(0).toInt()) }
        }
    }
}
