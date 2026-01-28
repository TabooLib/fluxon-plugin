package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event

import org.bukkit.event.HandlerList
import org.bukkit.plugin.RegisteredListener
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.HandlerList"])
@PlatformSide(Platform.BUKKIT)
object FnHandlerList {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HandlerList::class.java)
                .function("registerAll", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.registerAll(it.getRef(0) as Collection<RegisteredListener>)) }
                .function("registeredListeners", returnsObject().noParams()) { it.setReturnRef(it.target?.registeredListeners) }
        }
    }
}
