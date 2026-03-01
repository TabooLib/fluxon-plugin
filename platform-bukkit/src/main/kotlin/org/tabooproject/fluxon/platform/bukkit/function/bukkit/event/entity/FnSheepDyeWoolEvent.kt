package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.DyeColor
import org.bukkit.event.entity.SheepDyeWoolEvent
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

@Requires(classes = ["org.bukkit.event.entity.SheepDyeWoolEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSheepDyeWoolEvent {

    val TYPE = Type.fromClass(SheepDyeWoolEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SheepDyeWoolEvent::class.java)
                .function("entity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSheep.TYPE).noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("player", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("color", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE)) { it.target?.setColor(it.getRef(0) as DyeColor) }
                .function("handlers", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(SheepDyeWoolEvent.getHandlerList()) }
        }
    }
}
