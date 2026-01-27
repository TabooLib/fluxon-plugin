package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Particle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.Particle"])
@PlatformSide(Platform.BUKKIT)
object FnParticle {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle::class.java)
                .function("key", 0) { it.target?.key }
        }
    }
}

@Requires(classes = ["org.bukkit.Particle.DustOptions"])
@PlatformSide(Platform.BUKKIT)
object FnParticleDustOptions {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle.DustOptions::class.java)
                .function("color", 0) { it.target?.color }
                .function("size", 0) { it.target?.size }
        }
    }
}

@Requires(classes = ["org.bukkit.Particle.DustTransition"])
@PlatformSide(Platform.BUKKIT)
object FnParticleDustTransition {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle.DustTransition::class.java)
                .function("toColor", 0) { it.target?.toColor }
        }
    }
}
