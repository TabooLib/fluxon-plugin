package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.scoreboard.Score
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnScore {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Score::class.java)
                .function("player", 0) { it.target?.player }
                .function("entry", 0) { it.target?.entry }
                .function("objective", 0) { it.target?.objective }
                .function("score", 0) { it.target?.score }
                .function("setScore", 1) { it.target?.setScore(it.getNumber(0).toInt()) }
                .function("isScoreSet", 0) { it.target?.isScoreSet }
                .function("scoreboard", 0) { it.target?.scoreboard }
        }
    }
}
