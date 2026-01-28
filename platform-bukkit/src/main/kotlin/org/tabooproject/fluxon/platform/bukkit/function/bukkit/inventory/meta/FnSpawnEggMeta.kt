package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.entity.EntitySnapshot
import org.bukkit.entity.EntityType
import org.bukkit.inventory.meta.SpawnEggMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.SpawnEggMeta"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnEggMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnEggMeta::class.java)
                .function("spawnedType", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnedType) }
                .function("setSpawnedType", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnedType(it.getRef(0) as EntityType)) }
                .function("spawnedEntity", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnedEntity) }
                .function("setSpawnedEntity", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnedEntity(it.getRef(0) as EntitySnapshot)) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
