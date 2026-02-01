package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.scoreboard.ScoreboardManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.scoreboard.ScoreboardManager"])
@PlatformSide(Platform.BUKKIT)
object FnScoreboardManager {

    val TYPE = Type.fromClass(ScoreboardManager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ScoreboardManager::class.java)
                .function("mainScoreboard", returnsObject().noParams()) { it.setReturnRef(it.target?.mainScoreboard) }
                .syncFunction("newScoreboard", returnsObject().noParams()) { it.setReturnRef(it.target?.newScoreboard) }
        }
    }
}
