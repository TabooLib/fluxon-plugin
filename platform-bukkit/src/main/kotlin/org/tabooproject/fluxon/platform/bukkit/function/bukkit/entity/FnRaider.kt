package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Raid
import org.bukkit.block.Block
import org.bukkit.entity.Raider
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Raider"])
@PlatformSide(Platform.BUKKIT)
object FnRaider {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Raider::class.java)
                .function("setRaid", returnsObject().params(Type.OBJECT)) { it.target?.setRaid(it.getRef(0) as Raid) }
                .function("raid", returnsObject().noParams()) { it.target?.raid }
                .function("wave", returnsObject().noParams()) { it.target?.wave }
                .function("setWave", returnsObject().params(Type.OBJECT)) { it.target?.setWave(it.getInt(0).toInt()) }
                .function("patrolTarget", returnsObject().noParams()) { it.target?.patrolTarget }
                .function("setPatrolTarget", returnsObject().params(Type.OBJECT)) { it.target?.setPatrolTarget(it.getRef(0) as Block) }
                .function("isPatrolLeader", returns(Type.Z).noParams()) { it.target?.isPatrolLeader }
                .function("setPatrolLeader", returnsObject().params(Type.OBJECT)) { it.target?.setPatrolLeader(it.getBool(0)) }
                .function("isCanJoinRaid", returns(Type.Z).noParams()) { it.target?.isCanJoinRaid }
                .function("setCanJoinRaid", returnsObject().params(Type.OBJECT)) { it.target?.setCanJoinRaid(it.getBool(0)) }
                .function("ticksOutsideRaid", returnsObject().noParams()) { it.target?.ticksOutsideRaid }
                .function("setTicksOutsideRaid", returnsObject().params(Type.OBJECT)) { it.target?.setTicksOutsideRaid(it.getInt(0).toInt()) }
                .function("isCelebrating", returns(Type.Z).noParams()) { it.target?.isCelebrating }
                .function("setCelebrating", returnsObject().params(Type.OBJECT)) { it.target?.setCelebrating(it.getBool(0)) }
                .function("celebrationSound", returnsObject().noParams()) { it.target?.celebrationSound }
        }
    }
}
