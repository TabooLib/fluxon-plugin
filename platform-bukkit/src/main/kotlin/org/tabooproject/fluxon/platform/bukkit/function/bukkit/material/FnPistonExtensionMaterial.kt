package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.PistonExtensionMaterial
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.PistonExtensionMaterial"])
@PlatformSide(Platform.BUKKIT)
object FnPistonExtensionMaterial {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PistonExtensionMaterial::class.java)
                .function("setFacingDirection", returnsObject().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("facing", returnsObject().noParams()) { it.target?.facing }
                .function("isSticky", returns(Type.Z).noParams()) { it.target?.isSticky }
                .function("setSticky", returnsObject().params(Type.OBJECT)) { it.target?.setSticky(it.getBool(0)) }
                .function("attachedFace", returnsObject().noParams()) { it.target?.attachedFace }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
