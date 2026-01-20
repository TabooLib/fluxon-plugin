package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Llama
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLlama {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Llama::class.java)
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as Llama.Color) }
                .function("strength", 0) { it.target?.strength }
                .function("setStrength", 1) { it.target?.setStrength(it.getNumber(0).toInt()) }
                .function("inventory", 0) { it.target?.inventory }
        }
    }
}
