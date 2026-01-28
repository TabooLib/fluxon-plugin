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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.scoreboard.Scoreboard"])
@PlatformSide(Platform.BUKKIT)
object FnScoreboard {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Scoreboard::class.java)
                .syncFunction("registerNewObjective", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        2 -> it.target?.registerNewObjective(
                            it.getString(0)!!,
                            it.getString(1)!!
                        )

                        3 -> when (val var2 = it.getRef(1)) {
                            is String -> it.target?.registerNewObjective(it.getString(0)!!, var2, it.getString(2)!!)
                            is Criteria -> it.target?.registerNewObjective(it.getString(0)!!, var2, it.getString(2)!!)
                            else -> throw IllegalArgumentException("第二个参数必须是 String 或 Criteria 类型")
                        }

                        4 -> when (val var2 = it.getRef(1)) {
                            is String -> it.target?.registerNewObjective(
                                it.getString(0)!!,
                                var2,
                                it.getString(2)!!,
                                it.getRef(3) as RenderType
                            )

                            is Criteria -> it.target?.registerNewObjective(
                                it.getString(0)!!,
                                var2,
                                it.getString(2)!!,
                                it.getRef(3) as RenderType
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 String 或 Criteria 类型")
                        }
                        else -> error("Scoreboard#registerNewObjective 函数参数数量错误: ${"args"}")
                    }
                }
                .syncFunction("registerNewObjective", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        2 -> it.target?.registerNewObjective(
                            it.getString(0)!!,
                            it.getString(1)!!
                        )

                        3 -> when (val var2 = it.getRef(1)) {
                            is String -> it.target?.registerNewObjective(it.getString(0)!!, var2, it.getString(2)!!)
                            is Criteria -> it.target?.registerNewObjective(it.getString(0)!!, var2, it.getString(2)!!)
                            else -> throw IllegalArgumentException("第二个参数必须是 String 或 Criteria 类型")
                        }

                        4 -> when (val var2 = it.getRef(1)) {
                            is String -> it.target?.registerNewObjective(
                                it.getString(0)!!,
                                var2,
                                it.getString(2)!!,
                                it.getRef(3) as RenderType
                            )

                            is Criteria -> it.target?.registerNewObjective(
                                it.getString(0)!!,
                                var2,
                                it.getString(2)!!,
                                it.getRef(3) as RenderType
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 String 或 Criteria 类型")
                        }
                        else -> error("Scoreboard#registerNewObjective 函数参数数量错误: ${"args"}")
                    }
                }
                .syncFunction("registerNewObjective", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        2 -> it.target?.registerNewObjective(
                            it.getString(0)!!,
                            it.getString(1)!!
                        )

                        3 -> when (val var2 = it.getRef(1)) {
                            is String -> it.target?.registerNewObjective(it.getString(0)!!, var2, it.getString(2)!!)
                            is Criteria -> it.target?.registerNewObjective(it.getString(0)!!, var2, it.getString(2)!!)
                            else -> throw IllegalArgumentException("第二个参数必须是 String 或 Criteria 类型")
                        }

                        4 -> when (val var2 = it.getRef(1)) {
                            is String -> it.target?.registerNewObjective(
                                it.getString(0)!!,
                                var2,
                                it.getString(2)!!,
                                it.getRef(3) as RenderType
                            )

                            is Criteria -> it.target?.registerNewObjective(
                                it.getString(0)!!,
                                var2,
                                it.getString(2)!!,
                                it.getRef(3) as RenderType
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 String 或 Criteria 类型")
                        }
                        else -> error("Scoreboard#registerNewObjective 函数参数数量错误: ${"args"}")
                    }
                }
                .function("getObjective", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getObjective(var1)
                        is DisplaySlot -> it.target?.getObjective(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 DisplaySlot 类型")
                    }
                }
                .function("getObjectivesByCriteria", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getObjectivesByCriteria(var1)
                        is Criteria -> it.target?.getObjectivesByCriteria(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Criteria 类型")
                    }
                }
                .function("objectives", returnsObject().noParams()) { it.target?.objectives }
                .function("getScores", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is OfflinePlayer -> it.target?.getScores(var1)
                        is String -> it.target?.getScores(var1)
                        else -> throw IllegalArgumentException("参数必须是 OfflinePlayer 或 String 类型")
                    }
                }
                .function("resetScores", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is OfflinePlayer -> it.target?.resetScores(var1)
                        is String -> it.target?.resetScores(var1)
                        else -> throw IllegalArgumentException("参数必须是 OfflinePlayer 或 String 类型")
                    }
                }
                .function("getPlayerTeam", returnsObject().params(Type.OBJECT)) { it.target?.getPlayerTeam(it.getRef(0) as OfflinePlayer) }
                .function("getEntryTeam", returnsObject().params(Type.OBJECT)) { it.target?.getEntryTeam(it.getString(0)!!) }
                .function("getTeam", returnsObject().params(Type.OBJECT)) { it.target?.getTeam(it.getString(0)!!) }
                .function("teams", returnsObject().noParams()) { it.target?.teams }
                .function("registerNewTeam", returnsObject().params(Type.OBJECT)) { it.target?.registerNewTeam(it.getString(0)!!) }
                .function("players", returnsObject().noParams()) { it.target?.players }
                .function("entries", returnsObject().noParams()) { it.target?.entries }
                .function("clearSlot", returnsObject().params(Type.OBJECT)) { it.target?.clearSlot(it.getRef(0) as DisplaySlot) }
        }
    }
}
