package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.entity.EntitySnapshot
import org.bukkit.entity.EntityType
import org.bukkit.inventory.meta.SpawnEggMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSpawnEggMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnEggMeta::class.java)
                .function("spawnedType", 0) { it.target?.spawnedType }
                .function("setSpawnedType", 1) { it.target?.setSpawnedType(it.getArgument(0) as EntityType) }
                .function("spawnedEntity", 0) { it.target?.spawnedEntity }
                .function("setSpawnedEntity", 1) { it.target?.setSpawnedEntity(it.getArgument(0) as EntitySnapshot) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
