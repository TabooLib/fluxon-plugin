package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.PistonBaseMaterial
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.material.PistonBaseMaterial"])
@PlatformSide(Platform.BUKKIT)
object FnPistonBaseMaterial {

    val TYPE = Type.fromClass(PistonBaseMaterial::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PistonBaseMaterial::class.java)
                .function("setFacingDirection", returnsVoid().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("facing", returnsObject().noParams()) { it.setReturnRef(it.target?.facing) }
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPowered ?: false) }
                .function("setPowered", returnsVoid().params(Type.Z)) { it.target?.setPowered(it.getBool(0)) }
                .function("isSticky", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSticky ?: false) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
