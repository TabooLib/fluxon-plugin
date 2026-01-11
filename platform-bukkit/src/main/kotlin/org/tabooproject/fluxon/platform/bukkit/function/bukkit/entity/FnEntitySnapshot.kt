package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EntitySnapshot
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntitySnapshot {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntitySnapshot::class.java)
                .function("createEntity", 1) {
                    // Entity createEntity(@NotNull World var1)
                    // Entity createEntity(@NotNull Location var1)
                    TODO()
                }
                .function("entityType", 0) { it.target?.entityType }
        }
    }
}
