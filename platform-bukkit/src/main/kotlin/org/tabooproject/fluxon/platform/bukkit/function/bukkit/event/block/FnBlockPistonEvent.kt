package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPistonEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockPistonEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPistonEvent {

    val TYPE = Type.fromClass(BlockPistonEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPistonEvent::class.java)
                .function("isSticky", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSticky ?: false) }
                .function("direction", returns(FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.direction) }
        }
    }
}
