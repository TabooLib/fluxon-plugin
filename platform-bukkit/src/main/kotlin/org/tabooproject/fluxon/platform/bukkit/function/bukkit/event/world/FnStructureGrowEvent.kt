package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.StructureGrowEvent
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

@Requires(classes = ["org.bukkit.event.world.StructureGrowEvent"])
@PlatformSide(Platform.BUKKIT)
object FnStructureGrowEvent {

    val TYPE = Type.fromClass(StructureGrowEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureGrowEvent::class.java)
                .function("location",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
                .function("species", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeType.TYPE).noParams()) { it.setReturnRef(it.target?.species) }
                .function("isFromBonemeal", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFromBonemeal ?: false) }
                .function("player",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("blocks",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.blocks) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(StructureGrowEvent.getHandlerList()) }
        }
    }
}
