package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.OfflinePlayer
import org.bukkit.Statistic
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

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
                    // BanEntry<PlayerProfile> ban(@Nullable String var1, @Nullable Date var2, @Nullable String var3)
                    // BanEntry<PlayerProfile> ban(@Nullable String var1, @Nullable Instant var2, @Nullable String var3)
                    // BanEntry<PlayerProfile> ban(@Nullable String var1, @Nullable Duration var2, @Nullable String var3)
                    TODO()
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
                    // void incrementStatistic(@NotNull Statistic var1, int var2)
                    // void incrementStatistic(@NotNull Statistic var1, @NotNull Material var2)
                    // void incrementStatistic(@NotNull Statistic var1, @NotNull EntityType var2)
                    TODO()
                }
                .function("decrementStatistic", 2) {
                    // void decrementStatistic(@NotNull Statistic var1, int var2)
                    // void decrementStatistic(@NotNull Statistic var1, @NotNull Material var2)
                    // void decrementStatistic(@NotNull Statistic var1, @NotNull EntityType var2)
                    TODO()
                }
                .function("setStatistic", 2) {
                    it.target?.setStatistic(
                        it.getArgument(0) as Statistic,
                        it.getNumber(1).toInt()
                    )
                }
                .function("statistic", 1) { it.target?.getStatistic(it.getArgument(0) as Statistic) }
                .function("statistic", 2) {
                    // int getStatistic(@NotNull Statistic var1, @NotNull Material var2)
                    // int getStatistic(@NotNull Statistic var1, @NotNull EntityType var2)
                    TODO()
                }
                .function("incrementStatistic", 3) {
                    // void incrementStatistic(@NotNull Statistic var1, @NotNull Material var2, int var3)
                    // void incrementStatistic(@NotNull Statistic var1, @NotNull EntityType var2, int var3)
                    TODO()
                }
                .function("decrementStatistic", 3) {
                    // void decrementStatistic(@NotNull Statistic var1, @NotNull Material var2, int var3)
                    // void decrementStatistic(@NotNull Statistic var1, @NotNull EntityType var2, int var3)
                    TODO()
                }
                .function("setStatistic", 3) {
                    // void setStatistic(@NotNull Statistic var1, @NotNull Material var2, int var3)
                    // void setStatistic(@NotNull Statistic var1, @NotNull EntityType var2, int var3)
                    TODO()
                }
                .function("lastDeathLocation", 0) { it.target?.lastDeathLocation }
                .function("location", 0) { it.target?.location }
        }
    }
}
