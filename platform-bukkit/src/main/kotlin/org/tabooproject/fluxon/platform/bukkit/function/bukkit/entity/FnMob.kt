package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Mob
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Mob"])
@PlatformSide(Platform.BUKKIT)
object FnMob {

    val TYPE = Type.fromClass(Mob::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Mob::class.java)
                .function("setTarget",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE)) { it.target?.setTarget(it.getRef(0) as LivingEntity) }
                .function("target",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE).noParams()) { it.setReturnRef(it.target?.target) }
                .function("setAware", returnsVoid().params(Type.Z)) { it.target?.setAware(it.getBool(0)) }
                .function("isAware", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAware ?: false) }
                .function("ambientSound",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE).noParams()) { it.setReturnRef(it.target?.ambientSound) }
//                .function("possibleExperienceReward",returns(Type.I).noParams()) { it.setReturnRef(it.target?.possibleExperienceReward) }
//                .function("headRotationSpeed",returns(Type.I).noParams()) { it.setReturnRef(it.target?.headRotationSpeed) }
//                .function("maxHeadPitch",returns(Type.I).noParams()) { it.setReturnRef(it.target?.maxHeadPitch) }
//                .function("isAggressive", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAggressive ?: false) }
//                .function("setAggressive",returns(Type.OBJECT).params(Type.Z)) { it.setReturnRef(it.target?.isAggressive = it.getBool(0)) }
//                .function("isLeftHanded", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLeftHanded ?: false) }
//                .function("setLeftHanded",returns(Type.OBJECT).params(Type.Z)) { it.setReturnRef(it.target?.isLeftHanded = it.getBool(0)) }
        }
    }
}
