package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler

import org.bukkit.scheduler.BukkitWorker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBukkitWorker {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BukkitWorker::class.java)
                .function("taskId", 0) { it.target?.taskId }
                .function("owner", 0) { it.target?.owner }
                .function("thread", 0) { it.target?.thread }
        }
    }
}
