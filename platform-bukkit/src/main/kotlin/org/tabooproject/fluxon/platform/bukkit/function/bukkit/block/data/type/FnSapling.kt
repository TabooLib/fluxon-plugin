package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Sapling
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Sapling"])
@PlatformSide(Platform.BUKKIT)
object FnSapling {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sapling::class.java)
                .function("stage", returnsObject().noParams()) { it.setReturnRef(it.target?.stage) }
                .function("setStage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setStage(it.getInt(0).toInt())) }
                .function("maximumStage", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumStage) }
        }
    }
}
