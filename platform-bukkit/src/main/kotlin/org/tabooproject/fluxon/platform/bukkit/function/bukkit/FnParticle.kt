package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Particle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.Particle"])
@PlatformSide(Platform.BUKKIT)
object FnParticle {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle::class.java)
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
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
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("size", returns(Type.I).noParams()) { it.setReturnRef(it.target?.size) }
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
                .function("toColor", returnsObject().noParams()) { it.setReturnRef(it.target?.toColor) }
        }
    }
}
