package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.SkeletonHorse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSkeletonHorse {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SkeletonHorse::class.java)
                .function("isTrapped", 0) { it.target?.isTrapped }
                .function("setTrapped", 1) { it.target?.setTrapped(it.getBoolean(0)) }
                .function("trapTime", 0) { it.target?.trapTime }
                .function("setTrapTime", 1) { it.target?.setTrapTime(it.getNumber(0).toInt()) }
        }
    }
}
