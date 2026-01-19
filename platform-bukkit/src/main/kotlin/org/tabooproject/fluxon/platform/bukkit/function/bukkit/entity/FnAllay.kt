package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Allay
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAllay {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Allay::class.java)
                .function("canDuplicate", 0) { it.target?.canDuplicate() }
                .function("setCanDuplicate", 1) { it.target?.setCanDuplicate(it.getBoolean(0)) }
                .function("duplicationCooldown", 0) { it.target?.duplicationCooldown }
                .function("setDuplicationCooldown", 1) { it.target?.setDuplicationCooldown(it.getNumber(0).toLong()) }
                .function("resetDuplicationCooldown", 0) { it.target?.resetDuplicationCooldown() }
                .function("isDancing", 0) { it.target?.isDancing }
                .function("startDancing", 1) { it.target?.startDancing(it.getArgument(0) as Location) }
                .function("startDancing", 0) { it.target?.startDancing() }
                .function("stopDancing", 0) { it.target?.stopDancing() }
                .function("duplicateAllay", 0) { it.target?.duplicateAllay() }
                .function("jukebox", 0) { it.target?.jukebox }
        }
    }
}
