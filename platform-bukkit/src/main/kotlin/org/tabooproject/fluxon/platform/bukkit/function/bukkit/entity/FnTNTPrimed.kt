package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.entity.TNTPrimed
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTNTPrimed {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TNTPrimed::class.java)
                .function("setFuseTicks", 1) { it.target?.setFuseTicks(it.getNumber(0).toInt()) }
                .function("fuseTicks", 0) { it.target?.fuseTicks }
                .function("source", 0) { it.target?.source }
                .function("setSource", 1) { it.target?.setSource(it.getArgument(0) as Entity) }
        }
    }
}
