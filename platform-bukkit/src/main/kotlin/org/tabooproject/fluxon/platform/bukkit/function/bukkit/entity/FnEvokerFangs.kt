package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EvokerFangs
import org.bukkit.entity.LivingEntity
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


@Requires(classes = ["org.bukkit.entity.EvokerFangs"])
@PlatformSide(Platform.BUKKIT)
object FnEvokerFangs {

    val TYPE = Type.fromClass(EvokerFangs::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EvokerFangs::class.java)
                .function("owner",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE).noParams()) { it.setReturnRef(it.target?.owner) }
                .function("setOwner",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE)) { it.target?.setOwner(it.getRef(0) as LivingEntity) }
                .function("attackDelay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.attackDelay ?: 0) }
                .function("setAttackDelay", returnsVoid().params(Type.I)) { it.target?.setAttackDelay(it.getInt(0).toInt()) }
        }
    }
}
