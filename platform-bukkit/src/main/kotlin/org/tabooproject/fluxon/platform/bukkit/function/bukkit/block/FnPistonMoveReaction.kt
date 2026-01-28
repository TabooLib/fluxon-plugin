package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.PistonMoveReaction
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.PistonMoveReaction"])
@PlatformSide(Platform.BUKKIT)
object FnPistonMoveReaction {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PistonMoveReaction::class.java)
                .function("id", returnsObject().noParams()) { it.setReturnRef(it.target?.id) }
                // static
                .function("getById", returnsObject().params(Type.OBJECT)) { it.setReturnRef(PistonMoveReaction.getById(it.getInt(0).toInt())) }
        }
    }
}
