package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.BlockFace
import org.bukkit.entity.Shulker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Shulker"])
@PlatformSide(Platform.BUKKIT)
object FnShulker {

    val TYPE = Type.fromClass(Shulker::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Shulker::class.java)
                .function("peek", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.peek ?: 0f) }
                .function("setPeek", returnsVoid().params(Type.F)) { it.target?.setPeek(it.getFloat(0)) }
                .function("attachedFace", returnsObject().noParams()) { it.setReturnRef(it.target?.attachedFace) }
                .function("setAttachedFace", returnsVoid().params(Type.OBJECT)) { it.target?.setAttachedFace(it.getRef(0) as BlockFace) }
        }
    }
}
