package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Sapling
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Sapling"])
@PlatformSide(Platform.BUKKIT)
object FnSapling {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sapling::class.java)
                .function("isInstantGrowable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isInstantGrowable) }
                .function("setIsInstantGrowable", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setIsInstantGrowable(it.getBool(0))) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
