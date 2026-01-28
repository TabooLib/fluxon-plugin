package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.PoweredRail
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.PoweredRail"])
@PlatformSide(Platform.BUKKIT)
object FnPoweredRail {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PoweredRail::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.target?.isPowered }
                .function("setPowered", returnsObject().params(Type.OBJECT)) { it.target?.setPowered(it.getBool(0)) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
