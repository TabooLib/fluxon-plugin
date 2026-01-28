package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.scoreboard.Score
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.scoreboard.Score"])
@PlatformSide(Platform.BUKKIT)
object FnScore {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Score::class.java)
                .function("player", returnsObject().noParams()) { it.setReturnRef(it.target?.player) }
                .function("entry", returnsObject().noParams()) { it.setReturnRef(it.target?.entry) }
                .function("objective", returnsObject().noParams()) { it.setReturnRef(it.target?.objective) }
                .function("score", returnsObject().noParams()) { it.setReturnRef(it.target?.score) }
                .function("setScore", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setScore(it.getInt(0).toInt())) }
                .function("isScoreSet", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isScoreSet) }
                .function("scoreboard", returnsObject().noParams()) { it.setReturnRef(it.target?.scoreboard) }
        }
    }
}
