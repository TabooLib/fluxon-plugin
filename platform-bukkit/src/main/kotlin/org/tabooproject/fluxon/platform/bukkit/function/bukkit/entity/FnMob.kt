package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Mob"])
@PlatformSide(Platform.BUKKIT)
object FnMob {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Mob::class.java)
                .function("setTarget", returnsObject().params(Type.OBJECT)) { it.target?.setTarget(it.getRef(0) as LivingEntity) }
                .function("target", returnsObject().noParams()) { it.target?.target }
                .function("setAware", returnsObject().params(Type.OBJECT)) { it.target?.setAware(it.getBool(0)) }
                .function("isAware", returns(Type.Z).noParams()) { it.target?.isAware }
                .function("ambientSound", returnsObject().noParams()) { it.target?.ambientSound }
//                .function("possibleExperienceReward", returnsObject().noParams()) { it.target?.possibleExperienceReward }
//                .function("headRotationSpeed", returnsObject().noParams()) { it.target?.headRotationSpeed }
//                .function("maxHeadPitch", returnsObject().noParams()) { it.target?.maxHeadPitch }
//                .function("isAggressive", returns(Type.Z).noParams()) { it.target?.isAggressive }
//                .function("setAggressive", returnsObject().params(Type.OBJECT)) { it.target?.isAggressive = it.getBool(0) }
//                .function("isLeftHanded", returns(Type.Z).noParams()) { it.target?.isLeftHanded }
//                .function("setLeftHanded", returnsObject().params(Type.OBJECT)) { it.target?.isLeftHanded = it.getBool(0) }
        }
    }
}
