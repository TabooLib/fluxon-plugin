package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.FireworkEffect
import org.bukkit.inventory.meta.FireworkMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFireworkMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkMeta::class.java)
                .function("addEffect", 1) { it.target?.addEffect(it.getArgument(0) as FireworkEffect) }
                .function("addEffects", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.addEffects()
                    } else {
                        it.target?.addEffects(it.getArgument(0) as Iterable<FireworkEffect>)
                    }
                }
                .function("effects", 0) { it.target?.effects }
                .function("effectsSize", 0) { it.target?.effectsSize }
                .function("removeEffect", 1) { it.target?.removeEffect(it.getNumber(0).toInt()) }
                .function("clearEffects", 0) { it.target?.clearEffects() }
                .function("hasEffects", 0) { it.target?.hasEffects() }
                .function("power", 0) { it.target?.power }
                .function("setPower", 1) { it.target?.setPower(it.getNumber(0).toInt()) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
