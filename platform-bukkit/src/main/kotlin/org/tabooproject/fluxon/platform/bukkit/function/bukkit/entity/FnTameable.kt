package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AnimalTamer
import org.bukkit.entity.Tameable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnTameable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tameable::class.java)
                // 只读属性
//                .function("ownerUniqueId", 0) { it.target?.ownerUniqueId?.toString() }

                // 可读写属性
                .function("owner", 0) { it.target?.owner }
                .syncFunction("setOwner", 1) { it.target?.apply { owner = it.getArgument(0) as? AnimalTamer } }
                .function("isTamed", 0) { it.target?.isTamed }
                .syncFunction("setTamed", 1) { it.target?.apply { isTamed = it.getBoolean(0) } }
        }
    }
}
