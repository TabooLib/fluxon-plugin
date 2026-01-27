package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.scoreboard.ScoreboardManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.scoreboard.ScoreboardManager"])
@PlatformSide(Platform.BUKKIT)
object FnScoreboardManager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ScoreboardManager::class.java)
                .function("mainScoreboard", 0) { it.target?.mainScoreboard }
                .syncFunction("newScoreboard", 0) { it.target?.newScoreboard }
        }
    }
}
