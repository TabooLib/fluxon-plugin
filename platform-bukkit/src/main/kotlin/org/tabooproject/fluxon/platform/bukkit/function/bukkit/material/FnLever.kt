package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Lever
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

@Requires(classes = ["org.bukkit.material.Lever"])
@PlatformSide(Platform.BUKKIT)
object FnLever {

    val TYPE = Type.fromClass(Lever::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lever::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPowered ?: false) }
                .function("setPowered", returnsVoid().params(Type.Z)) { it.target?.setPowered(it.getBool(0)) }
                .function("attachedFace", returnsObject().noParams()) { it.setReturnRef(it.target?.attachedFace) }
                .function("setFacingDirection", returnsVoid().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
