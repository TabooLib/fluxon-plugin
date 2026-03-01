package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ExperienceOrb
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


@Requires(classes = ["org.bukkit.entity.ExperienceOrb"])
@PlatformSide(Platform.BUKKIT)
object FnExperienceOrb {

    val TYPE = Type.fromClass(ExperienceOrb::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExperienceOrb::class.java)
//                .function("isFromBottle", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFromBottle ?: false) }
//                .function("triggerEntityId", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.triggerEntityId?.toString()) }
//                .function("sourceEntityId", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.sourceEntityId?.toString()) }
//                .function("spawnReason", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.spawnReason?.name) }
//                .function("count", returns(Type.I).noParams()) { it.setReturnRef(it.target?.count) }
//                .function("setCount",returns(Type.OBJECT).params(Type.I)) { it.setReturnRef(it.target?.apply { count = it.getInt(0).toInt() }) }
                .function("experience", returns(Type.I).noParams()) { it.setReturnInt(it.target?.experience ?: 0) }
                .function("setExperience", returnsVoid().params(Type.I)) { it.target?.setExperience(it.getInt(0).toInt()) }
        }
    }
}
