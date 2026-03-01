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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.scoreboard.Scoreboard"])
@PlatformSide(Platform.BUKKIT)
object FnScoreboard {

    val TYPE = Type.fromClass(Scoreboard::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Scoreboard::class.java)
                .syncFunction("registerNewObjective",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnObjective.TYPE).params(Type.STRING, Type.STRING)) {
                    it.setReturnRef(it.target?.registerNewObjective(it.getString(0)!!, it.getString(1)!!))
                }
                .syncFunction("registerNewObjective",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnObjective.TYPE).params(Type.STRING, Type.STRING, Type.STRING)) {
                    it.setReturnRef(it.target?.registerNewObjective(it.getString(0)!!, it.getString(1)!!, it.getString(2)!!))
                }
                .syncFunction("registerNewObjective", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnObjective.TYPE).params(Type.STRING, Type.STRING, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnRenderType.TYPE)) {
                    it.setReturnRef(it.target?.registerNewObjective(it.getString(0)!!, it.getString(1)!!, it.getString(2)!!, it.getRef(3) as RenderType))
                }
                .syncFunction("registerNewObjective", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnObjective.TYPE).params(Type.STRING, Type.STRING, Type.STRING, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnRenderType.enumValue(it.getString(3))?.let { p3 ->
                        it.setReturnRef(it.target?.registerNewObjective(it.getString(0)!!, it.getString(1)!!, it.getString(2)!!, p3))
                    }
                }
                .syncFunction("registerNewObjective", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnObjective.TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE, Type.STRING)) {
                    it.setReturnRef(it.target?.registerNewObjective(it.getString(0)!!, it.getRef(1) as Criteria, it.getString(2)!!))
                }
                .syncFunction("registerNewObjective", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnObjective.TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnRenderType.TYPE)) {
                    it.setReturnRef(it.target?.registerNewObjective(it.getString(0)!!, it.getRef(1) as Criteria, it.getString(2)!!, it.getRef(3) as RenderType))
                }
                .function("getObjective", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnObjective.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getObjective(it.getString(0)!!)) }
                .function("getObjective", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnObjective.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnDisplaySlot.TYPE)) { it.setReturnRef(it.target?.getObjective(it.getRef(0) as DisplaySlot)) }
                .function("getObjectivesByCriteria", returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(Type.STRING)) { it.setReturnRef(it.target?.getObjectivesByCriteria(it.getString(0)!!)) }
                .function("getObjectivesByCriteria", returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE)) { it.setReturnRef(it.target?.getObjectivesByCriteria(it.getRef(0) as Criteria)) }
                .function("objectives", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.objectives) }
                .function("getScores", returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer.TYPE)) { it.setReturnRef(it.target?.getScores(it.getRef(0) as OfflinePlayer)) }
                .function("getScores", returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(Type.STRING)) { it.setReturnRef(it.target?.getScores(it.getString(0)!!)) }
                .function("resetScores", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer.TYPE)) { it.target?.resetScores(it.getRef(0) as OfflinePlayer) }
                .function("resetScores", returnsVoid().params(Type.STRING)) { it.target?.resetScores(it.getString(0)!!) }
                .function("getPlayerTeam",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnTeam.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer.TYPE)) { it.setReturnRef(it.target?.getPlayerTeam(it.getRef(0) as OfflinePlayer)) }
                .function("getEntryTeam",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnTeam.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getEntryTeam(it.getString(0)!!)) }
                .function("getTeam",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnTeam.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getTeam(it.getString(0)!!)) }
                .function("teams", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.teams) }
                .function("registerNewTeam",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnTeam.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.registerNewTeam(it.getString(0)!!)) }
                .function("players", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.players) }
                .function("entries", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.entries) }
                .function("clearSlot", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnDisplaySlot.TYPE)) { it.target?.clearSlot(it.getRef(0) as DisplaySlot)  }
                .function("clearSlot", returnsVoid().params(Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnDisplaySlot.enumValue(it.getString(0))?.let { p0 -> it.target?.clearSlot(p0) }
                }
        }
    }
}
