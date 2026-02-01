package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Sapling
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Sapling"])
@PlatformSide(Platform.BUKKIT)
object FnSapling {

    val TYPE = Type.fromClass(Sapling::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sapling::class.java)
                .function("stage", returns(Type.I).noParams()) { it.setReturnInt(it.target?.stage ?: 0) }
                .function("setStage", returnsVoid().params(Type.I)) { it.target?.setStage(it.getInt(0)) }
                .function("maximumStage", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumStage ?: 0) }
        }
    }
}
