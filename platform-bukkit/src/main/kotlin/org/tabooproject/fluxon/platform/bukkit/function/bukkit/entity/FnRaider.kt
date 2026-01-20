package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Raid
import org.bukkit.block.Block
import org.bukkit.entity.Raider
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnRaider {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Raider::class.java)
                .function("setRaid", 1) { it.target?.setRaid(it.getArgument(0) as Raid) }
                .function("raid", 0) { it.target?.raid }
                .function("wave", 0) { it.target?.wave }
                .function("setWave", 1) { it.target?.setWave(it.getNumber(0).toInt()) }
                .function("patrolTarget", 0) { it.target?.patrolTarget }
                .function("setPatrolTarget", 1) { it.target?.setPatrolTarget(it.getArgument(0) as Block) }
                .function("isPatrolLeader", 0) { it.target?.isPatrolLeader }
                .function("setPatrolLeader", 1) { it.target?.setPatrolLeader(it.getBoolean(0)) }
                .function("isCanJoinRaid", 0) { it.target?.isCanJoinRaid }
                .function("setCanJoinRaid", 1) { it.target?.setCanJoinRaid(it.getBoolean(0)) }
                .function("ticksOutsideRaid", 0) { it.target?.ticksOutsideRaid }
                .function("setTicksOutsideRaid", 1) { it.target?.setTicksOutsideRaid(it.getNumber(0).toInt()) }
                .function("isCelebrating", 0) { it.target?.isCelebrating }
                .function("setCelebrating", 1) { it.target?.setCelebrating(it.getBoolean(0)) }
                .function("celebrationSound", 0) { it.target?.celebrationSound }
        }
    }
}
