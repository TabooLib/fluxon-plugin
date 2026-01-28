package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.BlockFace
import org.bukkit.entity.Shulker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Shulker"])
@PlatformSide(Platform.BUKKIT)
object FnShulker {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Shulker::class.java)
                .function("peek", returnsObject().noParams()) { it.target?.peek }
                .function("setPeek", returnsObject().params(Type.OBJECT)) { it.target?.setPeek(it.getFloat(0)) }
                .function("attachedFace", returnsObject().noParams()) { it.target?.attachedFace }
                .function("setAttachedFace", returnsObject().params(Type.OBJECT)) { it.target?.setAttachedFace(it.getRef(0) as BlockFace) }
        }
    }
}
