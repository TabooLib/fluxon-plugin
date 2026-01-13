package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ExperienceOrb
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnExperienceOrb {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExperienceOrb::class.java)
                // 只读属性
//                .function("isFromBottle", 0) { it.target?.isFromBottle }
//                .function("triggerEntityId", 0) { it.target?.triggerEntityId?.toString() }
//                .function("sourceEntityId", 0) { it.target?.sourceEntityId?.toString() }
//                .function("spawnReason", 0) { it.target?.spawnReason?.name }

                // 可读写属性
                .function("experience", 0) { it.target?.experience }
                .syncFunction("setExperience", 1) { it.target?.apply { experience = it.getNumber(0).toInt() } }
//                .function("count", 0) { it.target?.count }
//                .syncFunction("setCount", 1) { it.target?.apply { count = it.getNumber(0).toInt() } }
        }
    }
}
