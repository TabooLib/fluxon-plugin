package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler

import org.bukkit.scheduler.BukkitWorker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.scheduler.BukkitWorker"])
@PlatformSide(Platform.BUKKIT)
object FnBukkitWorker {

    val TYPE = Type.fromClass(BukkitWorker::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BukkitWorker::class.java)
                .function("taskId",returns(Type.I).noParams()) { it.setReturnRef(it.target?.taskId) }
                .function("owner",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE).noParams()) { it.setReturnRef(it.target?.owner) }
                .function("thread", returns(Type.fromClass(Thread::class.java)).noParams()) { it.setReturnRef(it.target?.thread) }
        }
    }
}
