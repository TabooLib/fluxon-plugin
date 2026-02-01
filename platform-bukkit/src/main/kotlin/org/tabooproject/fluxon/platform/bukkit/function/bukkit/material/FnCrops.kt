package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.CropState
import org.bukkit.material.Crops
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Crops"])
@PlatformSide(Platform.BUKKIT)
object FnCrops {

    val TYPE = Type.fromClass(Crops::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Crops::class.java)
                .function("state", returnsObject().noParams()) { it.setReturnRef(it.target?.state) }
                .function("setState", returnsVoid().params(Type.OBJECT)) { it.target?.setState(it.getRef(0) as CropState) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
