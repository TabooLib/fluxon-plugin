package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EnderDragon
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEnderDragon {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderDragon::class.java)
                .function("phase", 0) { it.target?.phase }
                .function("setPhase", 1) { it.target?.setPhase(it.getArgument(0) as EnderDragon.Phase) }
                .function("dragonBattle", 0) { it.target?.dragonBattle }
                .function("deathAnimationTicks", 0) { it.target?.deathAnimationTicks }
        }
    }
}
