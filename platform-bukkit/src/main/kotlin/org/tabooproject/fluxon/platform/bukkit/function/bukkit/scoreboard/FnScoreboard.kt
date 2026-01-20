package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.OfflinePlayer
import org.bukkit.scoreboard.Criteria
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.scoreboard.RenderType
import org.bukkit.scoreboard.Scoreboard
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnScoreboard {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Scoreboard::class.java)
                .syncFunction("registerNewObjective", listOf(2, 3, 4)) {
                    when (it.arguments.size) {
                        2 -> it.target?.registerNewObjective(
                            it.getString(0)!!,
                            it.getString(1)!!
                        )

                        3 -> when (val var2 = it.getArgument(1)) {
                            is String -> it.target?.registerNewObjective(it.getString(0)!!, var2, it.getString(2)!!)
                            is Criteria -> it.target?.registerNewObjective(it.getString(0)!!, var2, it.getString(2)!!)
                            else -> throw IllegalArgumentException("第二个参数必须是 String 或 Criteria 类型")
                        }

                        4 -> when (val var2 = it.getArgument(1)) {
                            is String -> it.target?.registerNewObjective(
                                it.getString(0)!!,
                                var2,
                                it.getString(2)!!,
                                it.getArgument(3) as RenderType
                            )

                            is Criteria -> it.target?.registerNewObjective(
                                it.getString(0)!!,
                                var2,
                                it.getString(2)!!,
                                it.getArgument(3) as RenderType
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 String 或 Criteria 类型")
                        }
                        else -> error("Scoreboard#registerNewObjective 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("objective", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.getObjective(var1)
                        is DisplaySlot -> it.target?.getObjective(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 DisplaySlot 类型")
                    }
                }
                .function("objectivesByCriteria", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.getObjectivesByCriteria(var1)
                        is Criteria -> it.target?.getObjectivesByCriteria(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Criteria 类型")
                    }
                }
                .function("objectives", 0) { it.target?.objectives }
                .function("scores", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is OfflinePlayer -> it.target?.getScores(var1)
                        is String -> it.target?.getScores(var1)
                        else -> throw IllegalArgumentException("参数必须是 OfflinePlayer 或 String 类型")
                    }
                }
                .function("resetScores", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is OfflinePlayer -> it.target?.resetScores(var1)
                        is String -> it.target?.resetScores(var1)
                        else -> throw IllegalArgumentException("参数必须是 OfflinePlayer 或 String 类型")
                    }
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
