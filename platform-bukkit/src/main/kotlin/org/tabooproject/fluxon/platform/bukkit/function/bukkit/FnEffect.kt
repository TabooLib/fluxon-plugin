package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Effect
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEffect {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Effect::class.java)
                .function("id", 0) { it.target?.id }
                .function("type", 0) { it.target?.type }
                .function("data", 0) { it.target?.data }
                // static
                .function("getById", 1) { Effect.getById(it.getNumber(0).toInt()) }
        }
    }
}
