package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Creeper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCreeper {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Creeper::class.java)
                .function("isPowered", 0) { it.target?.isPowered }
                .function("setPowered", 1) { it.target?.setPowered(it.getBoolean(0)) }
                .function("setMaxFuseTicks", 1) { it.target?.setMaxFuseTicks(it.getNumber(0).toInt()) }
                .function("maxFuseTicks", 0) { it.target?.maxFuseTicks }
                .function("setFuseTicks", 1) { it.target?.setFuseTicks(it.getNumber(0).toInt()) }
                .function("fuseTicks", 0) { it.target?.fuseTicks }
                .function("setExplosionRadius", 1) { it.target?.setExplosionRadius(it.getNumber(0).toInt()) }
                .function("explosionRadius", 0) { it.target?.explosionRadius }
                .function("explode", 0) { it.target?.explode() }
                .function("ignite", 0) { it.target?.ignite() }
        }
    }
}
