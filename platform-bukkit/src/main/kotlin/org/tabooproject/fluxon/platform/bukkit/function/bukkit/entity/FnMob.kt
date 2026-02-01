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
                .function("setTarget", returnsVoid().params(Type.OBJECT)) { it.target?.setTarget(it.getRef(0) as LivingEntity) }
                .function("target", returnsObject().noParams()) { it.setReturnRef(it.target?.target) }
                .function("setAware", returnsVoid().params(Type.Z)) { it.target?.setAware(it.getBool(0)) }
                .function("isAware", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAware ?: false) }
                .function("ambientSound", returnsObject().noParams()) { it.setReturnRef(it.target?.ambientSound) }
//                .function("possibleExperienceReward", returnsObject().noParams()) { it.setReturnRef(it.target?.possibleExperienceReward) }
//                .function("headRotationSpeed", returnsObject().noParams()) { it.setReturnRef(it.target?.headRotationSpeed) }
//                .function("maxHeadPitch", returnsObject().noParams()) { it.setReturnRef(it.target?.maxHeadPitch) }
//                .function("isAggressive", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAggressive ?: false) }
//                .function("setAggressive", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.isAggressive = it.getBool(0)) }
//                .function("isLeftHanded", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLeftHanded ?: false) }
//                .function("setLeftHanded", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.isLeftHanded = it.getBool(0)) }
        }
    }
}
