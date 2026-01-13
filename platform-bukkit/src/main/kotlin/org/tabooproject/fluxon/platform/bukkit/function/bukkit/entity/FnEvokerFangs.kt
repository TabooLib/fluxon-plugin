package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EvokerFangs
import org.bukkit.entity.LivingEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnEvokerFangs {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EvokerFangs::class.java)
                // 拥有者
                .function("owner", 0) { it.target?.owner }
                .syncFunction("setOwner", 1) { it.target?.apply { owner = it.getArgument(0) as? LivingEntity } }
        }
    }
}
