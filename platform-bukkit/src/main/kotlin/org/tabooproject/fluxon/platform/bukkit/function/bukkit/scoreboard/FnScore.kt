package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.scoreboard.Score
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.scoreboard.Score"])
@PlatformSide(Platform.BUKKIT)
object FnScore {

    val TYPE = Type.fromClass(Score::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Score::class.java)
                .function("player", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("entry", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.entry) }
                .function("objective", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnObjective.TYPE).noParams()) { it.setReturnRef(it.target?.objective) }
                .function("score", returns(Type.I).noParams()) { it.setReturnInt(it.target?.score ?: 0) }
                .function("setScore", returnsVoid().params(Type.I)) { it.target?.setScore(it.getInt(0).toInt()) }
                .function("isScoreSet", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isScoreSet ?: false) }
                .function("scoreboard", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnScoreboard.TYPE).noParams()) { it.setReturnRef(it.target?.scoreboard) }
        }
    }
}
