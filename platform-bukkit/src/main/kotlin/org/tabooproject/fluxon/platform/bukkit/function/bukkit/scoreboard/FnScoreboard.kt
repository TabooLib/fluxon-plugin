package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.OfflinePlayer
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.scoreboard.Scoreboard
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnScoreboard {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Scoreboard::class.java)
                .function("registerNewObjective", 2) {
                    it.target?.registerNewObjective(
                        it.getString(0)!!,
                        it.getString(1)!!
                    )
                }
                .function("registerNewObjective", 3) {
                    // Objective registerNewObjective(@NotNull String var1, @NotNull String var2, @NotNull String var3)
                    // Objective registerNewObjective(@NotNull String var1, @NotNull Criteria var2, @NotNull String var3)
                    TODO()
                }
                .function("registerNewObjective", 4) {
                    // Objective registerNewObjective(@NotNull String var1, @NotNull String var2, @NotNull String var3, @NotNull RenderType var4)
                    // Objective registerNewObjective(@NotNull String var1, @NotNull Criteria var2, @NotNull String var3, @NotNull RenderType var4)
                    TODO()
                }
                .function("objective", 1) {
                    // Objective getObjective(@NotNull String var1)
                    // Objective getObjective(@NotNull DisplaySlot var1)
                    TODO()
                }
                .function("objectivesByCriteria", 1) {
                    // Set<Objective> getObjectivesByCriteria(@NotNull String var1)
                    // Set<Objective> getObjectivesByCriteria(@NotNull Criteria var1)
                    TODO()
                }
                .function("objectives", 0) { it.target?.objectives }
                .function("scores", 1) {
                    // Set<Score> getScores(@NotNull OfflinePlayer var1)
                    // Set<Score> getScores(@NotNull String var1)
                    TODO()
                }
                .function("resetScores", 1) {
                    // void resetScores(@NotNull OfflinePlayer var1)
                    // void resetScores(@NotNull String var1)
                    TODO()
                }
                .function("playerTeam", 1) { it.target?.getPlayerTeam(it.getArgument(0) as OfflinePlayer) }
                .function("entryTeam", 1) { it.target?.getEntryTeam(it.getString(0)!!) }
                .function("team", 1) { it.target?.getTeam(it.getString(0)!!) }
                .function("teams", 0) { it.target?.teams }
                .function("registerNewTeam", 1) { it.target?.registerNewTeam(it.getString(0)!!) }
                .function("players", 0) { it.target?.players }
                .function("entries", 0) { it.target?.entries }
                .function("clearSlot", 1) { it.target?.clearSlot(it.getArgument(0) as DisplaySlot) }
        }
    }
}
