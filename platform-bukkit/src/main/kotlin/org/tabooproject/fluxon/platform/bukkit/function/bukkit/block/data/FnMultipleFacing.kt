package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.BlockFace
import org.bukkit.block.data.MultipleFacing
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.MultipleFacing"])
@PlatformSide(Platform.BUKKIT)
object FnMultipleFacing {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MultipleFacing::class.java)
                .function("hasFace", returns(Type.Z).params(Type.OBJECT)) { it.target?.hasFace(it.getRef(0) as BlockFace) }
                .function("setFace", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.setFace(it.getRef(0) as BlockFace, it.getBool(1)) }
                .function("faces", returnsObject().noParams()) { it.target?.faces }
                .function("allowedFaces", returnsObject().noParams()) { it.target?.allowedFaces }
        }
    }
}
