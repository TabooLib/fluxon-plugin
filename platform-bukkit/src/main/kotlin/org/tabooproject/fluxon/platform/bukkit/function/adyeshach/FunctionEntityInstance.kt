package org.tabooproject.fluxon.platform.bukkit.function.adyeshach

import ink.ptms.adyeshach.core.entity.EntityInstance
import ink.ptms.adyeshach.core.entity.ModelEngine
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FunctionEntityInstance {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityInstance::class.java)
                // 函数
                .function("respawn", 0) {
                    it.target?.respawn()
                }
                // 属性
                .function("location", 0) {
                    it.target?.getLocation()
                }
                // 载具
                .function("passengers", 0) {
                    it.target?.getPassengers()
                }
                .function("refreshPassenger", 0) {
                    it.target?.refreshPassenger()
                }
                // 标签
                .function("setTag", 2) {
                    if (it.getArgument(1) != null) {
                        it.target?.setTag(it.getArgument(0).toString(), it.getArgument(1))
                    } else {
                        it.target?.removeTag(it.getArgument(0).toString())
                    }
                }
                .function("setPersistentTag", 2) {
                    if (it.getArgument(1) != null) {
                        it.target?.setPersistentTag(it.getArgument(0).toString(), it.getArgument(1).toString())
                    } else {
                        it.target?.removePersistentTag(it.getArgument(0).toString())
                    }
                }
                .function("hasTag", 1) {
                    it.target?.hasTag(it.getArgument(0).toString())
                }
                .function("hasPersistentTag", 1) {
                    it.target?.hasPersistentTag(it.getArgument(0).toString())
                }
                .function("getTag", 1) {
                    it.target?.getTag(it.getArgument(0).toString())
                }
                .function("consumeTag", 1) {
                    val id = it.getArgument(0).toString()
                    val find = it.target?.getTag(id)
                    it.target?.removeTag(id)
                    find
                }
                .function("getPersistentTag", 1) {
                    it.target?.getPersistentTag(it.getArgument(0).toString())
                }
                .function("consumePersistentTag", 1) {
                    val id = it.getArgument(0).toString()
                    val find = it.target?.getPersistentTag(id)
                    it.target?.removePersistentTag(id)
                    find
                }
                .function("tags", 0) {
                    it.target?.getTags()
                }
                .function("persistentTags", 0) {
                    it.target?.getPersistentTags()
                }
                // 模型
                .function("modelEngineName", 0) {
                    val target = it.target as ModelEngine
                    target.modelEngineName
                }
                .function("modelEngineUniqueId", 0) {
                    val target = it.target as ModelEngine
                    target.modelEngineUniqueId
                }
                .function("refreshModelEngine", 0) {
                    val target = it.target as ModelEngine
                    target.refreshModelEngine()
                }
                // 管理器
                .function("manager", 0) {
                    it.target?.manager
                }
        }
    }
}