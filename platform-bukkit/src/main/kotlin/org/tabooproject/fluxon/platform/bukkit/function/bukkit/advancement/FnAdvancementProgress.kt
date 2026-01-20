package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import org.bukkit.advancement.AdvancementProgress
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAdvancementProgress {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AdvancementProgress::class.java)
                .function("advancement", 0) { it.target?.advancement }
                .function("isDone", 0) { it.target?.isDone }
                .function("awardCriteria", 1) { it.target?.awardCriteria(it.getString(0)!!) }
                .function("revokeCriteria", 1) { it.target?.revokeCriteria(it.getString(0)!!) }
                .function("dateAwarded", 1) { it.target?.getDateAwarded(it.getString(0)!!) }
                .function("remainingCriteria", 0) { it.target?.remainingCriteria }
                .function("awardedCriteria", 0) { it.target?.awardedCriteria }
        }
    }
}
