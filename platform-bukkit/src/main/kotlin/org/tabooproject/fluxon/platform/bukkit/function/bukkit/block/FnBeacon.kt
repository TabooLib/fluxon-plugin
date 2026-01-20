package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Beacon
import org.bukkit.potion.PotionEffectType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBeacon {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Beacon::class.java)
                .function("entitiesInRange", 0) { it.target?.entitiesInRange }
                .function("tier", 0) { it.target?.tier }
                .function("primaryEffect", 0) { it.target?.primaryEffect }
                .function("setPrimaryEffect", 1) { it.target?.setPrimaryEffect(it.getArgument(0) as PotionEffectType) }
                .function("secondaryEffect", 0) { it.target?.secondaryEffect }
                .function(
                    "setSecondaryEffect",
                    1
                ) { it.target?.setSecondaryEffect(it.getArgument(0) as PotionEffectType) }
        }
    }
}
