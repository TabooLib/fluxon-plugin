package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.TurtleEgg
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.TurtleEgg"])
@PlatformSide(Platform.BUKKIT)
object FnTurtleEgg {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TurtleEgg::class.java)
                .function("eggs", returnsObject().noParams()) { it.setReturnRef(it.target?.eggs) }
                .function("setEggs", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEggs(it.getInt(0).toInt())) }
                .function("minimumEggs", returnsObject().noParams()) { it.setReturnRef(it.target?.minimumEggs) }
                .function("maximumEggs", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumEggs) }
        }
    }
}
