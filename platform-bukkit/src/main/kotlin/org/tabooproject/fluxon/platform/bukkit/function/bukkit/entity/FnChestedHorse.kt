package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ChestedHorse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnChestedHorse {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChestedHorse::class.java)
                .function("isCarryingChest", 0) { it.target?.isCarryingChest }
                .function("setCarryingChest", 1) { it.target?.setCarryingChest(it.getBoolean(0)) }
        }
    }
}
