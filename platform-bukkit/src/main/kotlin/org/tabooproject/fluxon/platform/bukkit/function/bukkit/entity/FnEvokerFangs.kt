package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EvokerFangs
import org.bukkit.entity.LivingEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.entity.EvokerFangs"])
@PlatformSide(Platform.BUKKIT)
object FnEvokerFangs {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EvokerFangs::class.java)
                .function("owner", returnsObject().noParams()) { it.setReturnRef(it.target?.owner) }
                .function("setOwner", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setOwner(it.getRef(0) as LivingEntity)) }
                .function("attackDelay", returnsObject().noParams()) { it.setReturnRef(it.target?.attackDelay) }
                .function("setAttackDelay", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAttackDelay(it.getInt(0).toInt())) }
        }
    }
}
