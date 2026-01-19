package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.FireworkEffect
import org.bukkit.inventory.meta.FireworkMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFireworkMeta {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FireworkMeta::class.java)
                .function("addEffect", 1) { it.target?.addEffect(it.getArgument(0) as FireworkEffect) }
                .function("addEffects", 0) { it.target?.addEffects() }
                .function("addEffects", 1) { it.target?.addEffects(it.getArgument(0) as Iterable<FireworkEffect>) }
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
