package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.bukkit.plugin.messaging.PluginMessageListenerRegistration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.messaging.PluginMessageListenerRegistration"])
@PlatformSide(Platform.BUKKIT)
object FnPluginMessageListenerRegistration {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginMessageListenerRegistration::class.java)
                .function("channel", returnsObject().noParams()) { it.target?.channel }
                .function("listener", returnsObject().noParams()) { it.target?.listener }
                .function("plugin", returnsObject().noParams()) { it.target?.plugin }
                .function("isValid", returns(Type.Z).noParams()) { it.target?.isValid }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
        }
    }
}
