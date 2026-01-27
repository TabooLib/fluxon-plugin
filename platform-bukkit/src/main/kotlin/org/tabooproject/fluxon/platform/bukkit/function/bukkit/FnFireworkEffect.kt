package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.FireworkEffect"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkEffect {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkEffect::class.java)
                // static
                .function("builder", 0) { FireworkEffect.builder() }
                .function("hasFlicker", 0) { it.target?.hasFlicker() }
                .function("hasTrail", 0) { it.target?.hasTrail() }
                .function("colors", 0) { it.target?.colors }
                .function("fadeColors", 0) { it.target?.fadeColors }
                .function("type", 0) { it.target?.type }
                // static
                .function("deserialize", 1) { FireworkEffect.deserialize(it.getArgument(0) as Map<String, Any>) }
                .function("toString", 0) { it.target?.toString() }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
        }
    }
}

@Requires(classes = ["org.bukkit.FireworkEffect.Builder"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkEffectBuilder {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkEffect.Builder::class.java)
                .function("with", 1) { it.target?.with(it.getArgument(0) as FireworkEffect.Type) }
                .function("withFlicker", 0) { it.target?.withFlicker() }
                .function("flicker", 1) { it.target?.flicker(it.getBoolean(0)) }
                .function("withTrail", 0) { it.target?.withTrail() }
                .function("trail", 1) { it.target?.trail(it.getBoolean(0)) }
                .function("withColor", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.withColor(it.arguments.map { arg -> arg as Color })
                    } else {
                        it.target?.withColor(it.getArgument(0) as Color)
                    }
                }
                .function("withFade", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.withFade(it.arguments.map { arg -> arg as Color })
                    } else {
                        it.target?.withFade(it.getArgument(0) as Color)
                    }
                }
                .function("build", 0) { it.target?.build() }
        }
    }
}
