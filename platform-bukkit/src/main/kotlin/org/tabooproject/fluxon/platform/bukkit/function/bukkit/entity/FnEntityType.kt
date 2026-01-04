package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEntityType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityType::class.java)
                // 只读属性
                .function("name", 0) { it.target?.name }
                .function("namespacedKey", 0) { it.target?.key }
//                .function("translationKey", 0) { it.target?.translationKey() }
                .function("isAlive", 0) { it.target?.isAlive }
                .function("isSpawnable", 0) { it.target?.isSpawnable }
                .function("ordinal", 0) { it.target?.ordinal }
        }
    }
}
