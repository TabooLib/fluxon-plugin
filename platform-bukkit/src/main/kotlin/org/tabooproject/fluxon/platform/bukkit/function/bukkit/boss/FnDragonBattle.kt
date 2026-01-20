package org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss

import org.bukkit.boss.DragonBattle
import org.bukkit.entity.EnderCrystal
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDragonBattle {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DragonBattle::class.java)
                .function("enderDragon", 0) { it.target?.enderDragon }
                .function("bossBar", 0) { it.target?.bossBar }
                .function("endPortalLocation", 0) { it.target?.endPortalLocation }
                .function("generateEndPortal", 1) { it.target?.generateEndPortal(it.getBoolean(0)) }
                .function("hasBeenPreviouslyKilled", 0) { it.target?.hasBeenPreviouslyKilled() }
                .function("setPreviouslyKilled", 1) { it.target?.setPreviouslyKilled(it.getBoolean(0)) }
                .function("initiateRespawn", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.initiateRespawn()
                    } else {
                        it.target?.initiateRespawn(it.getArgument(0) as Collection<EnderCrystal>)
                    }
                }
                .function("respawnPhase", 0) { it.target?.respawnPhase }
                .function(
                    "setRespawnPhase",
                    1
                ) { it.target?.setRespawnPhase(it.getArgument(0) as DragonBattle.RespawnPhase) }
                .function("resetCrystals", 0) { it.target?.resetCrystals() }
        }
    }
}
