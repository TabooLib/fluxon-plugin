package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Hatchable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Hatchable"])
@PlatformSide(Platform.BUKKIT)
object FnHatchable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Hatchable::class.java)
                .function("hatch", returnsObject().noParams()) { it.target?.hatch }
                .function("setHatch", returnsObject().params(Type.OBJECT)) { it.target?.setHatch(it.getInt(0).toInt()) }
                .function("maximumHatch", returnsObject().noParams()) { it.target?.maximumHatch }
        }
    }
}
