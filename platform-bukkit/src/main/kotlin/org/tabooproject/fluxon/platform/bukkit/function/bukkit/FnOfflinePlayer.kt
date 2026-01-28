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

@Requires(classes = ["org.bukkit.OfflinePlayer"])
@PlatformSide(Platform.BUKKIT)
object FnOfflinePlayer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OfflinePlayer::class.java)
                .function("isOnline", returns(Type.Z).noParams()) { it.target?.isOnline }
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                .function("uniqueId", returnsObject().noParams()) { it.target?.uniqueId }
                .function("playerProfile", returnsObject().noParams()) { it.target?.playerProfile }
                .function("isBanned", returns(Type.Z).noParams()) { it.target?.isBanned }
                .function("ban", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (val var2 = it.getRef(1)) {
                        is Date -> it.target?.ban(it.getString(0), var2, it.getString(2))
                        is Instant -> it.target?.ban(it.getString(0), var2, it.getString(2))
                        is Duration -> it.target?.ban(it.getString(0), var2, it.getString(2))
                        else -> throw IllegalArgumentException("参数 2 必须是 Date, Instant, 或 Duration 类型")
                    }
                }
                .function("isWhitelisted", returns(Type.Z).noParams()) { it.target?.isWhitelisted }
                .function("setWhitelisted", returnsObject().params(Type.OBJECT)) { it.target?.setWhitelisted(it.getBool(0)) }
                .function("player", returnsObject().noParams()) { it.target?.player }
                .function("firstPlayed", returnsObject().noParams()) { it.target?.firstPlayed }
                .function("lastPlayed", returnsObject().noParams()) { it.target?.lastPlayed }
                .function("hasPlayedBefore", returns(Type.Z).noParams()) { it.target?.hasPlayedBefore() }
                .function("bedSpawnLocation", returnsObject().noParams()) { it.target?.bedSpawnLocation }
                .function("respawnLocation", returnsObject().noParams()) { it.target?.respawnLocation }
                .function("incrementStatistic", returnsObject().params(Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.incrementStatistic(it.getRef(0) as Statistic)
                        2 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                            is Material -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 Int, Material, 或 EntityType 类型")
                        }

                        3 -> when (val var2 = it.getRef(1)) {
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
                        else -> error("OfflinePlayer#incrementStatistic 函数参数数量错误: ${"args"}")
                    }
                }
                .function("incrementStatistic", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.incrementStatistic(it.getRef(0) as Statistic)
                        2 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                            is Material -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 Int, Material, 或 EntityType 类型")
                        }

                        3 -> when (val var2 = it.getRef(1)) {
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
                        else -> error("OfflinePlayer#incrementStatistic 函数参数数量错误: ${"args"}")
                    }
                }
                .function("incrementStatistic", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.incrementStatistic(it.getRef(0) as Statistic)
                        2 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                            is Material -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> it.target?.incrementStatistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 Int, Material, 或 EntityType 类型")
                        }

                        3 -> when (val var2 = it.getRef(1)) {
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
                        else -> error("OfflinePlayer#incrementStatistic 函数参数数量错误: ${"args"}")
                    }
                }
                .function("decrementStatistic", returnsObject().params(Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.decrementStatistic(it.getRef(0) as Statistic)
                        2 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                            is Material -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 Int, Material, 或 EntityType 类型")
                        }

                        3 -> when (val var2 = it.getRef(1)) {
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
                        else -> error("OfflinePlayer#decrementStatistic 函数参数数量错误: ${"args"}")
                    }
                }
                .function("decrementStatistic", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.decrementStatistic(it.getRef(0) as Statistic)
                        2 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                            is Material -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 Int, Material, 或 EntityType 类型")
                        }

                        3 -> when (val var2 = it.getRef(1)) {
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
                        else -> error("OfflinePlayer#decrementStatistic 函数参数数量错误: ${"args"}")
                    }
                }
                .function("decrementStatistic", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.decrementStatistic(it.getRef(0) as Statistic)
                        2 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                            is Material -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> it.target?.decrementStatistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 Int, Material, 或 EntityType 类型")
                        }

                        3 -> when (val var2 = it.getRef(1)) {
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
                        else -> error("OfflinePlayer#decrementStatistic 函数参数数量错误: ${"args"}")
                    }
                }
                .function("setStatistic", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.setStatistic(
                            it.getRef(0) as Statistic,
                            it.getInt(1).toInt()
                        )
                    } else {
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
                }
                .function("setStatistic", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.setStatistic(
                            it.getRef(0) as Statistic,
                            it.getInt(1).toInt()
                        )
                    } else {
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
                }
                .function("getStatistic", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getStatistic(it.getRef(0) as Statistic)
                    } else {
                        when (val var2 = it.getRef(1)) {
                            is Material -> it.target?.getStatistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> it.target?.getStatistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 Material 或 EntityType 类型")
                        }
                    }
                }
                .function("getStatistic", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getStatistic(it.getRef(0) as Statistic)
                    } else {
                        when (val var2 = it.getRef(1)) {
                            is Material -> it.target?.getStatistic(it.getRef(0) as Statistic, var2)
                            is EntityType -> it.target?.getStatistic(it.getRef(0) as Statistic, var2)
                            else -> throw IllegalArgumentException("参数 2 必须是 Material 或 EntityType 类型")
                        }
                    }
                }
                .function("lastDeathLocation", returnsObject().noParams()) { it.target?.lastDeathLocation }
                .function("location", returnsObject().noParams()) { it.target?.location }
        }
    }
}
