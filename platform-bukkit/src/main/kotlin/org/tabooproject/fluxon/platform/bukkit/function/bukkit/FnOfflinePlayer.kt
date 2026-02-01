package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Material
import org.bukkit.OfflinePlayer
import org.bukkit.Statistic
import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.time.Duration
import java.time.Instant
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.OfflinePlayer"])
@PlatformSide(Platform.BUKKIT)
object FnOfflinePlayer {

    val TYPE = Type.fromClass(OfflinePlayer::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OfflinePlayer::class.java)
                .function("isOnline", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOnline ?: false) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("uniqueId", returnsObject().noParams()) { it.setReturnRef(it.target?.uniqueId) }
                .function("playerProfile", returnsObject().noParams()) { it.setReturnRef(it.target?.playerProfile) }
                .function("isBanned", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBanned ?: false) }
                .function("ban", returnsObject().params(Type.STRING, Type.OBJECT, Type.STRING)) {
                    it.setReturnRef(when (val var2 = it.getRef(1)) {
                        is Date -> it.target?.ban(it.getString(0), var2, it.getString(2))
                        is Instant -> it.target?.ban(it.getString(0), var2, it.getString(2))
                        is Duration -> it.target?.ban(it.getString(0), var2, it.getString(2))
                        else -> throw IllegalArgumentException("参数 2 必须是 Date, Instant, 或 Duration 类型")
                    })
                }
                .function("isWhitelisted", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isWhitelisted ?: false) }
                .function("setWhitelisted", returnsVoid().params(Type.Z)) { it.target?.setWhitelisted(it.getBool(0)) }
                .function("player", returnsObject().noParams()) { it.setReturnRef(it.target?.player) }
                .function("firstPlayed", returns(Type.J).noParams()) { it.setReturnLong(it.target?.firstPlayed ?: 0L) }
                .function("lastPlayed", returns(Type.J).noParams()) { it.setReturnLong(it.target?.lastPlayed ?: 0L) }
                .function("hasPlayedBefore", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasPlayedBefore() ?: false) }
                .function("bedSpawnLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.bedSpawnLocation) }
                .function("respawnLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.respawnLocation) }
                .function("incrementStatistic", returnsVoid().params(Type.OBJECT)) {
                    it.target?.incrementStatistic(it.getRef(0) as Statistic)
                }
                .function("incrementStatistic", returnsVoid().params(Type.OBJECT, Type.I)) {
                    it.target?.incrementStatistic(it.getRef(0) as Statistic, it.getInt(1).toInt())
                }
                .function("incrementStatistic", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    when (val var2 = it.getRef(1)) {
                        is Material -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                        is EntityType -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                        else -> throw IllegalArgumentException("参数 2 必须是 Material 或 EntityType 类型")
                    }
                }
                .function("incrementStatistic", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I)) {
                    when (val var2 = it.getRef(1)) {
                        is Material -> it.target?.incrementStatistic(
                            it.getRef(0) as Statistic,
                            var2,
                            it.getInt(2).toInt()
                        )

                        is EntityType -> it.target?.incrementStatistic(
                            it.getRef(0) as Statistic,
                            var2,
                            it.getInt(2).toInt()
                        )

                        else -> throw IllegalArgumentException("参数 2 必须是 Material 或 EntityType 类型")
                    }
                }
                .function("decrementStatistic", returnsVoid().params(Type.OBJECT)) {
                    it.target?.decrementStatistic(it.getRef(0) as Statistic)
                }
                .function("decrementStatistic", returnsVoid().params(Type.OBJECT, Type.I)) {
                    it.target?.decrementStatistic(it.getRef(0) as Statistic, it.getInt(1).toInt())
                }
                .function("decrementStatistic", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    when (val var2 = it.getRef(1)) {
                        is Material -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                        is EntityType -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                        else -> throw IllegalArgumentException("参数 2 必须是 Material 或 EntityType 类型")
                    }
                }
                .function("decrementStatistic", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I)) {
                    when (val var2 = it.getRef(1)) {
                        is Material -> it.target?.decrementStatistic(
                            it.getRef(0) as Statistic,
                            var2,
                            it.getInt(2).toInt()
                        )

                        is EntityType -> it.target?.decrementStatistic(
                            it.getRef(0) as Statistic,
                            var2,
                            it.getInt(2).toInt()
                        )

                        else -> throw IllegalArgumentException("参数 2 必须是 Material 或 EntityType 类型")
                    }
                }
                .function("setStatistic", returnsVoid().params(Type.OBJECT, Type.I)) {
                    it.target?.setStatistic(
                        it.getRef(0) as Statistic,
                        it.getInt(1).toInt()
                    )
                }
                .function("setStatistic", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I)) {
                    when (val var2 = it.getRef(1)) {
                        is Material -> it.target?.setStatistic(
                            it.getRef(0) as Statistic,
                            var2,
                            it.getInt(2).toInt()
                        )

                        is EntityType -> it.target?.setStatistic(
                            it.getRef(0) as Statistic,
                            var2,
                            it.getInt(2).toInt()
                        )

                        else -> throw IllegalArgumentException("参数 2 必须是 Material 或 EntityType 类型")
                    }
                }
                .function("getStatistic", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(it.target?.getStatistic(it.getRef(0) as Statistic) ?: 0)
                }
                .function("getStatistic", returns(Type.I).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnInt(
                        when (val var2 = it.getRef(1)) {
                            is Material -> it.target?.getStatistic(it.getRef(0) as Statistic, var2) ?: 0
                            is EntityType -> it.target?.getStatistic(it.getRef(0) as Statistic, var2) ?: 0
                            else -> throw IllegalArgumentException("参数 2 必须是 Material 或 EntityType 类型")
                        }
                    )
                }
                .function("lastDeathLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.lastDeathLocation) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
        }
    }
}
