package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.SculkShrieker
import org.bukkit.entity.Player
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
                .function("warningLevel", 0) { it.target?.warningLevel }
                .function("setWarningLevel", 1) { it.target?.setWarningLevel(it.getNumber(0).toInt()) }
                .function("tryShriek", 1) { it.target?.tryShriek(it.getArgument(0) as Player) }
        }
    }
}
