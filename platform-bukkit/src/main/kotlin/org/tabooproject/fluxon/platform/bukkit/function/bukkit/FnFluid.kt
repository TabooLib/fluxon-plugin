package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Fluid
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Fluid"])
@PlatformSide(Platform.BUKKIT)
object FnFluid {

    val TYPE = Type.fromClass(Fluid::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Fluid::class.java)
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
        }
    }
}
