package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BlockFace
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.block.BlockFace"])
@PlatformSide(Platform.BUKKIT)
object FnBlockFace : FnEnumGetter<BlockFace>() {

    override val enumClass: Class<BlockFace> = BlockFace::class.java

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockFace::class.java)
                .function("modX", returns(Type.I).noParams()) { it.setReturnInt(it.target?.modX ?: 0) }
                .function("modY", returns(Type.I).noParams()) { it.setReturnInt(it.target?.modY ?: 0) }
                .function("modZ", returns(Type.I).noParams()) { it.setReturnInt(it.target?.modZ ?: 0) }
                .function("direction", returnsObject().noParams()) { it.setReturnRef(it.target?.direction) }
                .function("isCartesian", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCartesian ?: false) }
                .function("oppositeFace", returnsObject().noParams()) { it.setReturnRef(it.target?.oppositeFace) }
        }
    }
}
