package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.trim

import org.bukkit.inventory.meta.trim.ArmorTrim
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnArmorTrim {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArmorTrim::class.java)
                .function("material", 0) { it.target?.material }
                .function("pattern", 0) { it.target?.pattern }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
        }
    }
}
