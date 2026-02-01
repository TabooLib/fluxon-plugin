package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.TurtleEgg
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

@Requires(classes = ["org.bukkit.block.data.type.TurtleEgg"])
@PlatformSide(Platform.BUKKIT)
object FnTurtleEgg {

    val TYPE = Type.fromClass(TurtleEgg::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TurtleEgg::class.java)
                .function("eggs", returns(Type.I).noParams()) { it.setReturnInt(it.target?.eggs ?: 0) }
                .function("setEggs", returnsVoid().params(Type.I)) { it.target?.setEggs(it.getInt(0).toInt()) }
                .function("minimumEggs", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minimumEggs ?: 0) }
                .function("maximumEggs", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumEggs ?: 0) }
        }
    }
}
