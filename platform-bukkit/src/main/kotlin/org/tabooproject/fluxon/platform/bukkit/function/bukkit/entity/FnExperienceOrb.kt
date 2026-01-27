package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ExperienceOrb
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires


@Requires(classes = ["org.bukkit.entity.ExperienceOrb"])
@PlatformSide(Platform.BUKKIT)
object FnExperienceOrb {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExperienceOrb::class.java)
//                .function("isFromBottle", 0) { it.target?.isFromBottle }
//                .function("triggerEntityId", 0) { it.target?.triggerEntityId?.toString() }
//                .function("sourceEntityId", 0) { it.target?.sourceEntityId?.toString() }
//                .function("spawnReason", 0) { it.target?.spawnReason?.name }
//                .function("count", 0) { it.target?.count }
//                .function("setCount", 1) { it.target?.apply { count = it.getNumber(0).toInt() } }
                .function("experience", 0) { it.target?.experience }
                .function("setExperience", 1) { it.target?.setExperience(it.getNumber(0).toInt()) }
        }
    }
}
