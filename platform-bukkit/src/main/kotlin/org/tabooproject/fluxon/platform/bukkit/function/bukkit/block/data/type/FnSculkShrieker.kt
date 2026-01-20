package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.SculkShrieker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSculkShrieker {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkShrieker::class.java)
                .function("isCanSummon", 0) { it.target?.isCanSummon }
                .function("setCanSummon", 1) { it.target?.setCanSummon(it.getBoolean(0)) }
                .function("isShrieking", 0) { it.target?.isShrieking }
                .function("setShrieking", 1) { it.target?.setShrieking(it.getBoolean(0)) }
        }
    }
}
