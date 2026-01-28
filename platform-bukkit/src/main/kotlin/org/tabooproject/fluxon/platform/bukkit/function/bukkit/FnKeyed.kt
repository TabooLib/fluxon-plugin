package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Keyed
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Keyed"])
@PlatformSide(Platform.BUKKIT)
object FnKeyed {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Keyed::class.java)
                .function("key", returnsObject().noParams()) { it.target?.key }
        }
    }
}
