package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EvokerFangs
import org.bukkit.entity.LivingEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires


@Requires(classes = ["org.bukkit.entity.EvokerFangs"])
@PlatformSide(Platform.BUKKIT)
object FnEvokerFangs {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EvokerFangs::class.java)
                .function("owner", 0) { it.target?.owner }
                .function("setOwner", 1) { it.target?.setOwner(it.getArgument(0) as LivingEntity) }
                .function("attackDelay", 0) { it.target?.attackDelay }
                .function("setAttackDelay", 1) { it.target?.setAttackDelay(it.getNumber(0).toInt()) }
        }
    }
}
