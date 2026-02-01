package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.RegisteredServiceProvider
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.RegisteredServiceProvider"])
@PlatformSide(Platform.BUKKIT)
object FnRegisteredServiceProvider {

    val TYPE = Type.fromClass(RegisteredServiceProvider::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RegisteredServiceProvider::class.java)
                .function("service", returnsObject().noParams()) { it.setReturnRef(it.target?.getService()) }
                .function("plugin", returnsObject().noParams()) { it.setReturnRef(it.target?.plugin) }
                .function("provider", returnsObject().noParams()) { it.setReturnRef(it.target?.getProvider()) }
                .function("priority", returnsObject().noParams()) { it.setReturnRef(it.target?.priority) }
                .function("compareTo", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(it.target?.compareTo(it.getRef(0) as RegisteredServiceProvider<*>) ?: 0)
                }
        }
    }
}
