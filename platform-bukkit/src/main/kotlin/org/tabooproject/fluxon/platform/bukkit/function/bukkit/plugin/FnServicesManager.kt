package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.ServicesManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.plugin.ServicesManager"])
@PlatformSide(Platform.BUKKIT)
object FnServicesManager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServicesManager::class.java)
                .function("unregisterAll", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.unregisterAll(it.getRef(0) as Plugin)) }
                .function("unregister", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.unregister(it.getRef(0)!!)) }
        }
    }
}
