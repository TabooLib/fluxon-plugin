package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler

import org.bukkit.scheduler.BukkitTask
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBukkitTask {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BukkitTask::class.java)
                .function("taskId", 0) { it.target?.taskId }
                .function("owner", 0) { it.target?.owner }
                .function("isSync", 0) { it.target?.isSync }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("cancel", 0) { it.target?.cancel() }
        }
    }
}
