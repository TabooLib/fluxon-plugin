package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockExpEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@Requires(classes = ["org.bukkit.event.block.BlockExpEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockExpEvent {

    val TYPE = Type.fromClass(BlockExpEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockExpEvent::class.java)
                .function("expToDrop", returns(Type.I).noParams()) { it.setReturnRef(it.target?.expToDrop) }
                .function("setExpToDrop", returnsVoid().params(Type.I)) { it.target?.setExpToDrop(it.getInt(0)) }
        }
    }
}
