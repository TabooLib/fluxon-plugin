package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityChangeBlockEvent
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

@Requires(classes = ["org.bukkit.event.entity.EntityChangeBlockEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityChangeBlockEvent {

    val TYPE = Type.fromClass(EntityChangeBlockEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityChangeBlockEvent::class.java)
                .function("block",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.block) }
                .function("to",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.to) }
                .function("blockData",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).noParams()) { it.setReturnRef(it.target?.blockData) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(EntityChangeBlockEvent.getHandlerList()) }
        }
    }
}
