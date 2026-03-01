package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.TrialSpawner"])
@PlatformSide(Platform.BUKKIT)
object FnTrialSpawner {

    val TYPE = Type.fromClass(org.bukkit.block.TrialSpawner::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.block.TrialSpawner::class.java)
                // .function("getCooldownEnd", returns(Type.J).noParams()) { it.setReturnLong(it.target?.getCooldownEnd() ?: 0L) }
                // .function("setCooldownEnd", returnsVoid().params(Type.J)) { it.target?.setCooldownEnd(it.getLong(0).toLong()) }
                // .function("getNextSpawnAttempt", returns(Type.J).noParams()) { it.setReturnLong(it.target?.getNextSpawnAttempt() ?: 0L) }
                // .function("setNextSpawnAttempt", returnsVoid().params(Type.J)) { it.target?.setNextSpawnAttempt(it.getLong(0).toLong()) }
                // .function("getCooldownLength", returns(Type.I).noParams()) { it.setReturnInt(it.target?.getCooldownLength() ?: 0) }
                // .function("setCooldownLength", returnsVoid().params(Type.I)) { it.target?.setCooldownLength(it.getInt(0).toInt()) }
                // .function("getRequiredPlayerRange", returns(Type.I).noParams()) { it.setReturnInt(it.target?.getRequiredPlayerRange() ?: 0) }
                // .function("setRequiredPlayerRange", returnsVoid().params(Type.I)) { it.target?.setRequiredPlayerRange(it.getInt(0).toInt()) }
                // .function("getTrackedPlayers", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.getTrackedPlayers()) }
                // .function("isTrackingPlayer", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) { it.setReturnBool(it.target?.isTrackingPlayer(it.getRef(0) as org.bukkit.entity.Player) ?: false) }
                // .function("startTrackingPlayer", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) { it.target?.startTrackingPlayer(it.getRef(0) as org.bukkit.entity.Player) }
                // .function("stopTrackingPlayer", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) { it.target?.stopTrackingPlayer(it.getRef(0) as org.bukkit.entity.Player) }
                // .function("getTrackedEntities", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.getTrackedEntities()) }
                // .function("isTrackingEntity", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.setReturnBool(it.target?.isTrackingEntity(it.getRef(0) as org.bukkit.entity.Entity) ?: false) }
                // .function("startTrackingEntity", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.target?.startTrackingEntity(it.getRef(0) as org.bukkit.entity.Entity) }
                // .function("stopTrackingEntity", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.target?.stopTrackingEntity(it.getRef(0) as org.bukkit.entity.Entity) }
                // .function("isOminous", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOminous() ?: false) }
                // .function("setOminous", returnsVoid().params(Type.Z)) { it.target?.setOminous(it.getBool(0)) }
                // .function("getNormalConfiguration", returns(Type.fromClass(org.bukkit.spawner.TrialSpawnerConfiguration::class.java)).noParams()) { it.setReturnRef(it.target?.getNormalConfiguration()) }
                // .function("getOminousConfiguration", returns(Type.fromClass(org.bukkit.spawner.TrialSpawnerConfiguration::class.java)).noParams()) { it.setReturnRef(it.target?.getOminousConfiguration()) }
        }
    }
}
