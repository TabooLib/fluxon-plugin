package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Statistic
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnStatistic {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Statistic::class.java)
                .function("type", 0) { it.target?.type }
                .function("isSubstatistic", 0) { it.target?.isSubstatistic }
                .function("isBlock", 0) { it.target?.isBlock }
                .function("key", 0) { it.target?.key }
        }
    }
}
