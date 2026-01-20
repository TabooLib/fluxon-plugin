package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Mob"])
@PlatformSide(Platform.BUKKIT)
object FnMob {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Mob::class.java)
                .function("setTarget", 1) { it.target?.setTarget(it.getArgument(0) as LivingEntity) }
                .function("target", 0) { it.target?.target }
                .function("setAware", 1) { it.target?.setAware(it.getBoolean(0)) }
                .function("isAware", 0) { it.target?.isAware }
                .function("ambientSound", 0) { it.target?.ambientSound }
//                .function("possibleExperienceReward", 0) { it.target?.possibleExperienceReward }
//                .function("headRotationSpeed", 0) { it.target?.headRotationSpeed }
//                .function("maxHeadPitch", 0) { it.target?.maxHeadPitch }
//                .function("isAggressive", 0) { it.target?.isAggressive }
//                .function("setAggressive", 1) { it.target?.isAggressive = it.getBoolean(0) }
//                .function("isLeftHanded", 0) { it.target?.isLeftHanded }
//                .function("setLeftHanded", 1) { it.target?.isLeftHanded = it.getBoolean(0) }
        }
    }
}
