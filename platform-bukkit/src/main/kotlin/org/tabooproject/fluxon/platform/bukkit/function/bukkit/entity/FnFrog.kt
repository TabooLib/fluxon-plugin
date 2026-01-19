package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.entity.Frog
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFrog {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Frog::class.java)
                .function("tongueTarget", 0) { it.target?.tongueTarget }
                .function("setTongueTarget", 1) { it.target?.setTongueTarget(it.getArgument(0) as Entity) }
                .function("variant", 0) { it.target?.variant }
                .function("setVariant", 1) { it.target?.setVariant(it.getArgument(0) as Frog.Variant) }

            registerExtension(Frog.Variant::class.java)
                .function("key", 0) { it.target?.key }
        }
    }
}
