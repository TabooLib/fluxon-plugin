package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.CauldronLevelChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.block.CauldronLevelChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnCauldronLevelChangeEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CauldronLevelChangeEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.target?.entity }
                .function("reason", returnsObject().noParams()) { it.target?.reason }
                .function("newState", returnsObject().noParams()) { it.target?.newState }
                .function("oldLevel", returnsObject().noParams()) { it.target?.oldLevel }
                .function("newLevel", returnsObject().noParams()) { it.target?.newLevel }
                .function("setNewLevel", returnsObject().params(Type.OBJECT)) { it.target?.setNewLevel(it.getInt(0).toInt()) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.target?.isCancelled }
                .function("setCancelled", returnsObject().params(Type.OBJECT)) { it.target?.setCancelled(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.target?.handlers }
                // static
                .function("handlerList", returnsObject().noParams()) { CauldronLevelChangeEvent.getHandlerList() }
        }
    }
}
