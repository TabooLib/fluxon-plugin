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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Raider"])
@PlatformSide(Platform.BUKKIT)
object FnRaider {

    val TYPE = Type.fromClass(Raider::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Raider::class.java)
                .function("setRaid", returnsVoid().params(Type.OBJECT)) { it.target?.setRaid(it.getRef(0) as Raid) }
                .function("raid", returnsObject().noParams()) { it.setReturnRef(it.target?.raid) }
                .function("wave", returns(Type.I).noParams()) { it.setReturnInt(it.target?.wave ?: 0) }
                .function("setWave", returnsVoid().params(Type.I)) { it.target?.setWave(it.getInt(0).toInt()) }
                .function("patrolTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.patrolTarget) }
                .function("setPatrolTarget", returnsVoid().params(Type.OBJECT)) { it.target?.setPatrolTarget(it.getRef(0) as Block) }
                .function("isPatrolLeader", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPatrolLeader ?: false) }
                .function("setPatrolLeader", returnsVoid().params(Type.Z)) { it.target?.setPatrolLeader(it.getBool(0)) }
                .function("isCanJoinRaid", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCanJoinRaid ?: false) }
                .function("setCanJoinRaid", returnsVoid().params(Type.Z)) { it.target?.setCanJoinRaid(it.getBool(0)) }
                .function("ticksOutsideRaid", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksOutsideRaid ?: 0) }
                .function("setTicksOutsideRaid", returnsVoid().params(Type.I)) { it.target?.setTicksOutsideRaid(it.getInt(0).toInt()) }
                .function("isCelebrating", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCelebrating ?: false) }
                .function("setCelebrating", returnsVoid().params(Type.Z)) { it.target?.setCelebrating(it.getBool(0)) }
                .function("celebrationSound", returnsObject().noParams()) { it.setReturnRef(it.target?.celebrationSound) }
        }
    }
}
