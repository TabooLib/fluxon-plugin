package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Particle
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.library.xseries.particles.XParticle
import kotlin.jvm.optionals.getOrNull

@Requires(classes = ["org.bukkit.Particle"])
@PlatformSide(Platform.BUKKIT)
object FnParticle : FnEnumGetter<Particle>() {

    override val enumClass: Class<Particle> = Particle::class.java

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle::class.java)
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
        }
    }

    override fun enumValue(value: String): Particle? {
        return XParticle.of(value).getOrNull()?.get()
    }
}

@Requires(classes = ["org.bukkit.Particle.DustOptions"])
@PlatformSide(Platform.BUKKIT)
object FnParticleDustOptions {

    val TYPE = Type.fromClass(Particle.DustOptions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle.DustOptions::class.java)
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("size", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.size ?: 0.0f) }
        }
    }
}

@Requires(classes = ["org.bukkit.Particle.DustTransition"])
@PlatformSide(Platform.BUKKIT)
object FnParticleDustTransition {

    val TYPE = Type.fromClass(Particle.DustTransition::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle.DustTransition::class.java)
                .function("toColor", returnsObject().noParams()) { it.setReturnRef(it.target?.toColor) }
        }
    }
}
