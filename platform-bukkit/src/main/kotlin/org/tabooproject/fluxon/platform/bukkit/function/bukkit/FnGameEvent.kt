package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.GameEvent
import org.bukkit.NamespacedKey
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnGameEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GameEvent::class.java)
                // static
                .function("byKey", 1) { GameEvent.getByKey(it.getArgument(0) as NamespacedKey) }
                // static
                .function("values", 0) { GameEvent.values() }
        }
    }
}
