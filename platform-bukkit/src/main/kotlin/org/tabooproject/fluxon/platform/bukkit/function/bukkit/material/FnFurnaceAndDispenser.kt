package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.FurnaceAndDispenser
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.material.FurnaceAndDispenser"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceAndDispenser {

    val TYPE = Type.fromClass(FurnaceAndDispenser::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceAndDispenser::class.java)
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
