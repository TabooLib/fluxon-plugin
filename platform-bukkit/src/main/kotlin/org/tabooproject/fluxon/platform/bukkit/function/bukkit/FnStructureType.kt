package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.StructureType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnStructureType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureType::class.java)
                .function("name", 0) { it.target?.name }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("toString", 0) { it.target?.toString() }
                .function("key", 0) { it.target?.key }
        }
    }
}
