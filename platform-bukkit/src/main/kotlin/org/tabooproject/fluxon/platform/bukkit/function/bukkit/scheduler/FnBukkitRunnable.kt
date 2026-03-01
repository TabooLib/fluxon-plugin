package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.scheduler.BukkitRunnable"])
@PlatformSide(Platform.BUKKIT)
object FnBukkitRunnable {

    val TYPE = Type.fromClass(org.bukkit.scheduler.BukkitRunnable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.scheduler.BukkitRunnable::class.java)
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled() ?: false) }
                .function("cancel", returnsVoid().noParams()) { it.target?.cancel() }
                .function("runTask", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler.FnBukkitTask.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.setReturnRef(it.target?.runTask(it.getRef(0) as org.bukkit.plugin.Plugin)) }
                .function("runTaskAsynchronously", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler.FnBukkitTask.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.setReturnRef(it.target?.runTaskAsynchronously(it.getRef(0) as org.bukkit.plugin.Plugin)) }
                .function("runTaskLater", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler.FnBukkitTask.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.J)) { it.setReturnRef(it.target?.runTaskLater(it.getRef(0) as org.bukkit.plugin.Plugin, it.getLong(1).toLong())) }
                .function("runTaskLaterAsynchronously", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler.FnBukkitTask.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.J)) { it.setReturnRef(it.target?.runTaskLaterAsynchronously(it.getRef(0) as org.bukkit.plugin.Plugin, it.getLong(1).toLong())) }
                .function("runTaskTimer", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler.FnBukkitTask.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.J, Type.J)) { it.setReturnRef(it.target?.runTaskTimer(it.getRef(0) as org.bukkit.plugin.Plugin, it.getLong(1).toLong(), it.getLong(2).toLong())) }
                .function("runTaskTimerAsynchronously", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler.FnBukkitTask.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.J, Type.J)) { it.setReturnRef(it.target?.runTaskTimerAsynchronously(it.getRef(0) as org.bukkit.plugin.Plugin, it.getLong(1).toLong(), it.getLong(2).toLong())) }
                .function("getTaskId", returns(Type.I).noParams()) { it.setReturnInt(it.target?.getTaskId() ?: 0) }
                // .function("checkScheduled", returnsVoid().noParams()) { it.target?.checkScheduled() }
                // .function("checkNotYetScheduled", returnsVoid().noParams()) { it.target?.checkNotYetScheduled() }
                // .function("setupTask", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler.FnBukkitTask.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scheduler.FnBukkitTask.TYPE)) { it.setReturnRef(it.target?.setupTask(it.getRef(0) as org.bukkit.scheduler.BukkitTask)) }
        }
    }
}
