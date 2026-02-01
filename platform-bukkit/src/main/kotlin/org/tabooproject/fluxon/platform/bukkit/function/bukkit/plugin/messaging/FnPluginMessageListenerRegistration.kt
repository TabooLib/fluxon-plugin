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

    val TYPE = Type.fromClass(PluginMessageListenerRegistration::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginMessageListenerRegistration::class.java)
                .function("channel", returnsObject().noParams()) { it.setReturnRef(it.target?.channel) }
                .function("listener", returnsObject().noParams()) { it.setReturnRef(it.target?.listener) }
                .function("plugin", returnsObject().noParams()) { it.setReturnRef(it.target?.plugin) }
                .function("isValid", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isValid ?: false) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.equals(it.getRef(0)) ?: false)
                }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnInt(it.target?.hashCode() ?: 0) }
        }
    }
}
