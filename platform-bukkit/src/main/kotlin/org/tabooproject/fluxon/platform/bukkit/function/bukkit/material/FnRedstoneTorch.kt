package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.RedstoneTorch
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.RedstoneTorch"])
@PlatformSide(Platform.BUKKIT)
object FnRedstoneTorch {

    val TYPE = Type.fromClass(RedstoneTorch::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RedstoneTorch::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPowered ?: false) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
