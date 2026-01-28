package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ExperienceOrb
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.entity.ExperienceOrb"])
@PlatformSide(Platform.BUKKIT)
object FnExperienceOrb {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExperienceOrb::class.java)
//                .function("isFromBottle", returns(Type.Z).noParams()) { it.target?.isFromBottle }
//                .function("triggerEntityId", returnsObject().noParams()) { it.target?.triggerEntityId?.toString() }
//                .function("sourceEntityId", returnsObject().noParams()) { it.target?.sourceEntityId?.toString() }
//                .function("spawnReason", returnsObject().noParams()) { it.target?.spawnReason?.name }
//                .function("count", returns(Type.I).noParams()) { it.target?.count }
//                .function("setCount", returnsObject().params(Type.OBJECT)) { it.target?.apply { count = it.getInt(0).toInt() } }
                .function("experience", returnsObject().noParams()) { it.target?.experience }
                .function("setExperience", returnsObject().params(Type.OBJECT)) { it.target?.setExperience(it.getInt(0).toInt()) }
        }
    }
}
