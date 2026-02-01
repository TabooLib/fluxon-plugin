package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.EntityBlockStorage
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.EntityBlockStorage"])
@PlatformSide(Platform.BUKKIT)
object FnEntityBlockStorage {

    val TYPE = Type.fromClass(EntityBlockStorage::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityBlockStorage::class.java)
                .function("isFull", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFull ?: false) }
                .function("entityCount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.entityCount ?: 0) }
                .function("maxEntities", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxEntities ?: 0) }
                .function("setMaxEntities", returnsVoid().params(Type.I)) { it.target?.setMaxEntities(it.getInt(0).toInt()) }
                .function("releaseEntities", returnsVoid().noParams()) { it.target?.releaseEntities() }
                .function("addEntity", returnsVoid().params(FnEntity.TYPE)) {
                    (it.target as? EntityBlockStorage<Entity>)?.addEntity(it.getRef(0) as Entity)
                }
        }
    }
}
