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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.RegisteredListener"])
@PlatformSide(Platform.BUKKIT)
object FnRegisteredListener {

    val TYPE = Type.fromClass(RegisteredListener::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RegisteredListener::class.java)
                .function("listener", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnListener.TYPE).noParams()) { it.setReturnRef(it.target?.listener) }
                .function("plugin",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE).noParams()) { it.setReturnRef(it.target?.plugin) }
                .function("priority",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEventPriority.TYPE).noParams()) { it.setReturnRef(it.target?.priority) }
                .function("callEvent", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEvent.TYPE)) { it.target?.callEvent(it.getRef(0) as Event) }
                .function("isIgnoringCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isIgnoringCancelled ?: false) }
        }
    }
}
