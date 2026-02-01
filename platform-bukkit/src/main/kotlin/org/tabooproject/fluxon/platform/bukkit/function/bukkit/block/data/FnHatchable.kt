package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Hatchable
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

@Requires(classes = ["org.bukkit.block.data.Hatchable"])
@PlatformSide(Platform.BUKKIT)
object FnHatchable {

    val TYPE = Type.fromClass(Hatchable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hatchable::class.java)
                .function("hatch", returns(Type.I).noParams()) { it.setReturnInt(it.target?.hatch ?: 0) }
                .function("setHatch", returnsVoid().params(Type.I)) { it.target?.setHatch(it.getInt(0).toInt()) }
                .function("maximumHatch", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumHatch ?: 0) }
        }
    }
}
