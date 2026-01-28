package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.EntityBlockStorage
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.EntityBlockStorage"])
@PlatformSide(Platform.BUKKIT)
object FnEntityBlockStorage {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityBlockStorage::class.java)
                .function("isFull", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isFull) }
                .function("entityCount", returnsObject().noParams()) { it.setReturnRef(it.target?.entityCount) }
                .function("maxEntities", returnsObject().noParams()) { it.setReturnRef(it.target?.maxEntities) }
                .function("setMaxEntities", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxEntities(it.getInt(0).toInt())) }
                .function("releaseEntities", returnsObject().noParams()) { it.setReturnRef(it.target?.releaseEntities()) }
                .function("addEntity", returnsObject().params(Type.OBJECT)) { it.setReturnRef((it.target as? EntityBlockStorage<Entity>)?.addEntity(it.getRef(0) as Entity)) }
        }
    }
}
