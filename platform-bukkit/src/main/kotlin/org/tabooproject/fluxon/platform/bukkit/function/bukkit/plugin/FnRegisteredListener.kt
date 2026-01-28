package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.event.Event
import org.bukkit.plugin.RegisteredListener
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.RegisteredListener"])
@PlatformSide(Platform.BUKKIT)
object FnRegisteredListener {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RegisteredListener::class.java)
                .function("listener", returnsObject().noParams()) { it.target?.listener }
                .function("plugin", returnsObject().noParams()) { it.target?.plugin }
                .function("priority", returnsObject().noParams()) { it.target?.priority }
                .function("callEvent", returnsObject().params(Type.OBJECT)) { it.target?.callEvent(it.getRef(0) as Event) }
                .function("isIgnoringCancelled", returns(Type.Z).noParams()) { it.target?.isIgnoringCancelled }
        }
    }
}
