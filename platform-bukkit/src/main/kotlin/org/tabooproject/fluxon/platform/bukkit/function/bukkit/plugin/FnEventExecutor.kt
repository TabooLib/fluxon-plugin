package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.event.Event
import org.bukkit.event.Listener
import org.bukkit.plugin.EventExecutor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.plugin.EventExecutor"])
@PlatformSide(Platform.BUKKIT)
object FnEventExecutor {

    val TYPE = Type.fromClass(EventExecutor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EventExecutor::class.java)
                .function("execute", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnListener.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEvent.TYPE)) {
                    it.target?.execute(
                        it.getRef(0) as Listener,
                        it.getRef(1) as Event
                    )
                }
        }
    }
}
