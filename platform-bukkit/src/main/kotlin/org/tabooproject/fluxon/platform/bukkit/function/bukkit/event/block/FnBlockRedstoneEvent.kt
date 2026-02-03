package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockRedstoneEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockRedstoneEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockRedstoneEvent {

    val TYPE = Type.fromClass(BlockRedstoneEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockRedstoneEvent::class.java)
                .function("oldCurrent", returns(Type.I).noParams()) { it.setReturnRef(it.target?.oldCurrent) }
                .function("newCurrent", returns(Type.I).noParams()) { it.setReturnRef(it.target?.newCurrent) }
                .function("setNewCurrent", returnsVoid().params(Type.I)) { it.target?.setNewCurrent(it.getInt(0)) }
        }
    }
}
