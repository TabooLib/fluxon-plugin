package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.IronGolem
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnIronGolem {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(IronGolem::class.java)
                .function("isPlayerCreated", 0) { it.target?.isPlayerCreated }
                .function("setPlayerCreated", 1) { it.target?.setPlayerCreated(it.getBoolean(0)) }
        }
    }
}
