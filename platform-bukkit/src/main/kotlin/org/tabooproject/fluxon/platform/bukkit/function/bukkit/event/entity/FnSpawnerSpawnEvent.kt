package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.SpawnerSpawnEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.entity.SpawnerSpawnEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnerSpawnEvent {

    val TYPE = Type.fromClass(SpawnerSpawnEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnerSpawnEvent::class.java)
                .function("spawner", returnsObject().noParams()) { it.setReturnRef(it.target?.spawner) }
        }
    }
}
