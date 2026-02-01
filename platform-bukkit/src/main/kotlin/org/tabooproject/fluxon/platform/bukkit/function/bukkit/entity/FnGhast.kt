package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Ghast
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Ghast"])
@PlatformSide(Platform.BUKKIT)
object FnGhast {

    val TYPE = Type.fromClass(Ghast::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ghast::class.java)
                .function("isCharging", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCharging ?: false) }
                .function("setCharging", returnsVoid().params(Type.Z)) { it.target?.setCharging(it.getBool(0)) }
        }
    }
}
