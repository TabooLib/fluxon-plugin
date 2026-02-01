package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Torch
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.material.Torch"])
@PlatformSide(Platform.BUKKIT)
object FnTorch {

    val TYPE = Type.fromClass(Torch::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Torch::class.java)
                .function("attachedFace", returnsObject().noParams()) { it.setReturnRef(it.target?.attachedFace) }
                .function("setFacingDirection", returnsVoid().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
