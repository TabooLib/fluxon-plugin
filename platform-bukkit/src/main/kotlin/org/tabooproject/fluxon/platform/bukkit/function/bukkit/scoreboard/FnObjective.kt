package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.OfflinePlayer
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.scoreboard.Objective
import org.bukkit.scoreboard.RenderType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnObjective {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Objective::class.java)
                .function("name", 0) { it.target?.name }
                .function("displayName", 0) { it.target?.displayName }
                .function("setDisplayName", 1) { it.target?.setDisplayName(it.getString(0)!!) }
                .function("criteria", 0) { it.target?.criteria }
                .function("trackedCriteria", 0) { it.target?.trackedCriteria }
                .function("isModifiable", 0) { it.target?.isModifiable }
                .function("scoreboard", 0) { it.target?.scoreboard }
                .function("unregister", 0) { it.target?.unregister() }
                .function("setDisplaySlot", 1) { it.target?.setDisplaySlot(it.getArgument(0) as DisplaySlot) }
                .function("displaySlot", 0) { it.target?.displaySlot }
                .function("setRenderType", 1) { it.target?.setRenderType(it.getArgument(0) as RenderType) }
                .function("renderType", 0) { it.target?.renderType }
                .function("getScore", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is OfflinePlayer -> it.target?.getScore(var1)
                        is String -> it.target?.getScore(var1)
                        else -> throw IllegalArgumentException("参数必须是 OfflinePlayer 或 String 类型")
                    }
                }
        }
    }
}
