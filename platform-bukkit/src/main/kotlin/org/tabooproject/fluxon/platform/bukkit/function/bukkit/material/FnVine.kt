package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Vine
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Vine"])
@PlatformSide(Platform.BUKKIT)
object FnVine {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vine::class.java)
                .function("isOnFace", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isOnFace(it.getRef(0) as BlockFace)) }
                .function("putOnFace", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.putOnFace(it.getRef(0) as BlockFace)) }
                .function("removeFromFace", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeFromFace(it.getRef(0) as BlockFace)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
