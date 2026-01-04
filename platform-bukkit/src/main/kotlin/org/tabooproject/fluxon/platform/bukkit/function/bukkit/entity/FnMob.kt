package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMob {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Mob::class.java)
                // 只读属性
                .function("ambientSound", 0) { it.target?.ambientSound }
//                .function("possibleExperienceReward", 0) { it.target?.possibleExperienceReward }
//                .function("headRotationSpeed", 0) { it.target?.headRotationSpeed }
//                .function("maxHeadPitch", 0) { it.target?.maxHeadPitch }

                // 可读写属性
                .function("target", 0) { it.target?.target }
                .syncFunction("setTarget", 1) { it.target?.apply { target = it.getArgument(0) as? LivingEntity } }
                .function("isAware", 0) { it.target?.isAware }
                .syncFunction("setAware", 1) { it.target?.apply { isAware = it.getBoolean(0) } }
//                .function("isAggressive", 0) { it.target?.isAggressive }
//                .syncFunction("setAggressive", 1) { it.target?.apply { isAggressive = it.getBoolean(0) } }
//                .function("isLeftHanded", 0) { it.target?.isLeftHanded }
//                .syncFunction("setLeftHanded", 1) { it.target?.apply { isLeftHanded = it.getBoolean(0) } }
        }
    }
}
