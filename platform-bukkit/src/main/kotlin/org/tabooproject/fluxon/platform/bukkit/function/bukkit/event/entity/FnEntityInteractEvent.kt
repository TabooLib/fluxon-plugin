package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityInteractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.entity.EntityInteractEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityInteractEvent {

    val TYPE = Type.fromClass(EntityInteractEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityInteractEvent::class.java)
                .function("block",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.getBlock()) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityInteractEvent.getHandlerList()) }
        }
    }
}
