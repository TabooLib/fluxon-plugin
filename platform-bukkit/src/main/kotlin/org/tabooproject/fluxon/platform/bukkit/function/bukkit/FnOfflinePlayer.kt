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

object FnOfflinePlayer {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OfflinePlayer::class.java)
                .function("isOnline", 0) { it.target?.isOnline }
                .function("name", 0) { it.target?.name }
                .function("uniqueId", 0) { it.target?.uniqueId }
                .function("playerProfile", 0) { it.target?.playerProfile }
                .function("isBanned", 0) { it.target?.isBanned }
                .function("ban", 3) {
                    when (val var2 = it.getArgument(1)) {
                        is Date -> it.target?.ban(it.getString(0), var2, it.getString(2))
                        is Instant -> it.target?.ban(it.getString(0), var2, it.getString(2))
                        is Duration -> it.target?.ban(it.getString(0), var2, it.getString(2))
                        else -> throw IllegalArgumentException("参数2必须是 Date, Instant, 或 Duration 类型")
                    }
                }
                .function("isWhitelisted", 0) { it.target?.isWhitelisted }
                .function("setWhitelisted", 1) { it.target?.setWhitelisted(it.getBoolean(0)) }
                .function("player", 0) { it.target?.player }
                .function("firstPlayed", 0) { it.target?.firstPlayed }
                .function("lastPlayed", 0) { it.target?.lastPlayed }
                .function("hasPlayedBefore", 0) { it.target?.hasPlayedBefore() }
                .function("bedSpawnLocation", 0) { it.target?.bedSpawnLocation }
                .function("respawnLocation", 0) { it.target?.respawnLocation }
                .function("incrementStatistic", 1) { it.target?.incrementStatistic(it.getArgument(0) as Statistic) }
                .function("decrementStatistic", 1) { it.target?.decrementStatistic(it.getArgument(0) as Statistic) }
                .function("incrementStatistic", 2) {
                    when (val var2 = it.getArgument(1)) {
                        is Int -> it.target?.incrementStatistic(it.getArgument(0) as Statistic, var2)
                        is Material -> it.target?.incrementStatistic(it.getArgument(0) as Statistic, var2)
                        is EntityType -> it.target?.incrementStatistic(it.getArgument(0) as Statistic, var2)
                        else -> throw IllegalArgumentException("参数2必须是 Int, Material, 或 EntityType 类型")
                    }
                }
                .function("decrementStatistic", 2) {
                    when (val var2 = it.getArgument(1)) {
                        is Int -> it.target?.decrementStatistic(it.getArgument(0) as Statistic, var2)
                        is Material -> it.target?.decrementStatistic(it.getArgument(0) as Statistic, var2)
                        is EntityType -> it.target?.decrementStatistic(it.getArgument(0) as Statistic, var2)
                        else -> throw IllegalArgumentException("参数2必须是 Int, Material, 或 EntityType 类型")
                    }
                }
                .function("setStatistic", 2) {
                    it.target?.setStatistic(
                        it.getArgument(0) as Statistic,
                        it.getNumber(1).toInt()
                    )
                }
                .function("statistic", 1) { it.target?.getStatistic(it.getArgument(0) as Statistic) }
                .function("statistic", 2) {
                    when (val var2 = it.getArgument(1)) {
                        is Material -> it.target?.getStatistic(it.getArgument(0) as Statistic, var2)
                        is EntityType -> it.target?.getStatistic(it.getArgument(0) as Statistic, var2)
                        else -> throw IllegalArgumentException("参数2必须是 Material 或 EntityType 类型")
                    }
                }
                .function("incrementStatistic", 3) {
                    when (val var2 = it.getArgument(1)) {
                        is Material -> it.target?.incrementStatistic(
                            it.getArgument(0) as Statistic,
                            var2,
                            it.getNumber(2).toInt()
                        )

                        is EntityType -> it.target?.incrementStatistic(
                            it.getArgument(0) as Statistic,
                            var2,
                            it.getNumber(2).toInt()
                        )

                        else -> throw IllegalArgumentException("参数2必须是 Material 或 EntityType 类型")
                    }
                }
                .function("decrementStatistic", 3) {
                    when (val var2 = it.getArgument(1)) {
                        is Material -> it.target?.decrementStatistic(
                            it.getArgument(0) as Statistic,
                            var2,
                            it.getNumber(2).toInt()
                        )

                        is EntityType -> it.target?.decrementStatistic(
                            it.getArgument(0) as Statistic,
                            var2,
                            it.getNumber(2).toInt()
                        )

                        else -> throw IllegalArgumentException("参数2必须是 Material 或 EntityType 类型")
                    }
                }
                .function("setStatistic", 3) {
                    when (val var2 = it.getArgument(1)) {
                        is Material -> it.target?.setStatistic(
                            it.getArgument(0) as Statistic,
                            var2,
                            it.getNumber(2).toInt()
                        )

                        is EntityType -> it.target?.setStatistic(
                            it.getArgument(0) as Statistic,
                            var2,
                            it.getNumber(2).toInt()
                        )

                        else -> throw IllegalArgumentException("参数2必须是 Material 或 EntityType 类型")
                    }
                }
                .function("lastDeathLocation", 0) { it.target?.lastDeathLocation }
                .function("location", 0) { it.target?.location }
        }
    }
}
