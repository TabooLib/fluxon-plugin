package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Turtle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Turtle"])
@PlatformSide(Platform.BUKKIT)
object FnTurtle {

    val TYPE = Type.fromClass(Turtle::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Turtle::class.java)
                .function("hasEgg", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasEgg() ?: false) }
                .function("isLayingEgg", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLayingEgg ?: false) }
        }
    }
}
