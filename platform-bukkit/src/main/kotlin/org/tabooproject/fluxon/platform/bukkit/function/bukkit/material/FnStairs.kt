package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Stairs
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Stairs"])
@PlatformSide(Platform.BUKKIT)
object FnStairs {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Stairs::class.java)
                .function("ascendingDirection", returnsObject().noParams()) { it.target?.ascendingDirection }
                .function("descendingDirection", returnsObject().noParams()) { it.target?.descendingDirection }
                .function("setFacingDirection", returnsObject().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("facing", returnsObject().noParams()) { it.target?.facing }
                .function("isInverted", returns(Type.Z).noParams()) { it.target?.isInverted }
                .function("setInverted", returnsObject().params(Type.OBJECT)) { it.target?.setInverted(it.getBool(0)) }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
