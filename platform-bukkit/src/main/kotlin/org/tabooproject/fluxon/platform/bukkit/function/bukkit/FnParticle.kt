package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Particle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnParticle {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle::class.java)
                .function("key", 0) { it.target?.key }

            registerExtension(Particle.DustOptions::class.java)
                .function("color", 0) { it.target?.color }
                .function("size", 0) { it.target?.size }

            registerExtension(Particle.DustTransition::class.java)
                .function("toColor", 0) { it.target?.toColor }
        }
    }
}
