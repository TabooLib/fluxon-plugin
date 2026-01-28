package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Ghast
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Ghast"])
@PlatformSide(Platform.BUKKIT)
object FnGhast {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ghast::class.java)
                .function("isCharging", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCharging) }
                .function("setCharging", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCharging(it.getBool(0))) }
        }
    }
}
