package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.EntityBlockStorage
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityBlockStorage {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityBlockStorage::class.java)
                .function("isFull", 0) { it.target?.isFull }
                .function("entityCount", 0) { it.target?.entityCount }
                .function("maxEntities", 0) { it.target?.maxEntities }
                .function("setMaxEntities", 1) { it.target?.setMaxEntities(it.getNumber(0).toInt()) }
                .function("releaseEntities", 0) { it.target?.releaseEntities() }
                .function("addEntity", 1) { (it.target as? EntityBlockStorage<Any>)?.addEntity(it.getArgument(0)!!) }
        }
    }
}
