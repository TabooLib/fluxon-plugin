package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.event.Event
import org.bukkit.plugin.TimedRegisteredListener
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.TimedRegisteredListener"])
@PlatformSide(Platform.BUKKIT)
object FnTimedRegisteredListener {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TimedRegisteredListener::class.java)
                .function("callEvent", returnsObject().params(Type.OBJECT)) { it.target?.callEvent(it.getRef(0) as Event) }
                .function("reset", returnsObject().noParams()) { it.target?.reset() }
                .function("count", returns(Type.I).noParams()) { it.target?.count }
                .function("totalTime", returnsObject().noParams()) { it.target?.totalTime }
                .function("hasMultiple", returns(Type.Z).noParams()) { it.target?.hasMultiple() }
        }
    }
}
