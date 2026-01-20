package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.NamespacedKey
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnNamespacedKey {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NamespacedKey::class.java)
                .function("namespace", 0) { it.target?.namespace }
                .function("key", 0) { it.target?.key }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("toString", 0) { it.target?.toString() }
                // static
                .function("minecraft", 1) { NamespacedKey.minecraft(it.getString(0)!!) }
                // static
                .function("fromString", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        NamespacedKey.fromString(it.getString(0)!!)
                    } else {
                        NamespacedKey.fromString(it.getString(0)!!, it.getArgument(1) as Plugin)
                    }
                }
        }
    }
}
