package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.entity.EntityType
import org.bukkit.material.SpawnEgg
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSpawnEgg {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnEgg::class.java)
                .function("spawnedType", 0) { it.target?.spawnedType }
                .function("setSpawnedType", 1) { it.target?.setSpawnedType(it.getArgument(0) as EntityType) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
