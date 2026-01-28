package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Nameable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Nameable"])
@PlatformSide(Platform.BUKKIT)
object FnNameable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Nameable::class.java)
                .function("customName", returnsObject().noParams()) { it.setReturnRef(it.target?.customName) }
                .function("setCustomName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCustomName(it.getString(0))) }
        }
    }
}
