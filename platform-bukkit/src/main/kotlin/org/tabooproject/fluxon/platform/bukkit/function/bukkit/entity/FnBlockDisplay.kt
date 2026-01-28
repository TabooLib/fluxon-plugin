package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.data.BlockData
import org.bukkit.entity.BlockDisplay
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.BlockDisplay"])
@PlatformSide(Platform.BUKKIT)
object FnBlockDisplay {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDisplay::class.java)
                .function("block", returnsObject().noParams()) { it.setReturnRef(it.target?.block) }
                .function("setBlock", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBlock(it.getRef(0) as BlockData)) }
        }
    }
}
