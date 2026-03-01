package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler

import org.bukkit.scheduler.BukkitTask
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.scheduler.BukkitTask"])
@PlatformSide(Platform.BUKKIT)
object FnBukkitTask {

    val TYPE = Type.fromClass(BukkitTask::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BukkitTask::class.java)
                .function("taskId", returns(Type.I).noParams()) { it.setReturnInt(it.target?.taskId ?: 0) }
                .function("owner",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE).noParams()) { it.setReturnRef(it.target?.owner) }
                .function("isSync", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSync ?: false) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("cancel", returnsVoid().noParams()) { it.target?.cancel() }
        }
    }
}
