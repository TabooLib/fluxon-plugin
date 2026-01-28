package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler

import org.bukkit.scheduler.BukkitTask
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.scheduler.BukkitTask"])
@PlatformSide(Platform.BUKKIT)
object FnBukkitTask {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BukkitTask::class.java)
                .function("taskId", returnsObject().noParams()) { it.setReturnRef(it.target?.taskId) }
                .function("owner", returnsObject().noParams()) { it.setReturnRef(it.target?.owner) }
                .function("isSync", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isSync) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCancelled) }
                .function("cancel", returnsObject().noParams()) { it.setReturnRef(it.target?.cancel()) }
        }
    }
}
