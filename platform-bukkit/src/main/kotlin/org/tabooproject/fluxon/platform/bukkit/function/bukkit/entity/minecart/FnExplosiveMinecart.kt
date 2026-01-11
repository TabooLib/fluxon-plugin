package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.minecart

import org.bukkit.entity.minecart.ExplosiveMinecart
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnExplosiveMinecart {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExplosiveMinecart::class.java)
                .function("setFuseTicks", 1) { it.target?.setFuseTicks(it.getNumber(0).toInt()) }
                .function("fuseTicks", 0) { it.target?.fuseTicks }
                .function("ignite", 0) { it.target?.ignite() }
                .function("isIgnited", 0) { it.target?.isIgnited }
                .function("explode", 0) { it.target?.explode() }
                .function("explode", 1) { it.target?.explode(it.getNumber(0).toDouble()) }
        }
    }
}
