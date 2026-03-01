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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.SpawnEggMeta"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnEggMeta {

    val TYPE = Type.fromClass(SpawnEggMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnEggMeta::class.java)
                .function("spawnedType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE).noParams()) { it.setReturnRef(it.target?.spawnedType) }
                .function("setSpawnedType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) { it.target?.setSpawnedType(it.getRef(0) as EntityType) }
                .function("spawnedEntity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntitySnapshot.TYPE).noParams()) { it.setReturnRef(it.target?.spawnedEntity) }
                .function("setSpawnedEntity",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntitySnapshot.TYPE)) { it.target?.setSpawnedEntity(it.getRef(0) as EntitySnapshot) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnSpawnEggMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
