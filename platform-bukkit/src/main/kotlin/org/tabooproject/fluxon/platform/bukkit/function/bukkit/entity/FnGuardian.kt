package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Guardian
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnGuardian {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Guardian::class.java)
                .function("setLaser", 1) { it.target?.setLaser(it.getBoolean(0)) }
                .function("hasLaser", 0) { it.target?.hasLaser() }
                .function("laserDuration", 0) { it.target?.laserDuration }
                .function("setLaserTicks", 1) { it.target?.setLaserTicks(it.getNumber(0).toInt()) }
                .function("laserTicks", 0) { it.target?.laserTicks }
                .function("isElder", 0) { it.target?.isElder }
                .function("setElder", 1) { it.target?.setElder(it.getBoolean(0)) }
                .function("isMoving", 0) { it.target?.isMoving }
        }
    }
}
