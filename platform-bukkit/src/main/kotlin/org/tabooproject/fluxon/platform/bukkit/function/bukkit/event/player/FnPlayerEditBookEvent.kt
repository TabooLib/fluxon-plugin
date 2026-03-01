package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerEditBookEvent
import org.bukkit.inventory.meta.BookMeta
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

@Requires(classes = ["org.bukkit.event.player.PlayerEditBookEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerEditBookEvent {

    val TYPE = Type.fromClass(PlayerEditBookEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerEditBookEvent::class.java)
                .function("previousBookMeta",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnBookMeta.TYPE).noParams()) { it.setReturnRef(it.target?.previousBookMeta) }
                .function("newBookMeta",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnBookMeta.TYPE).noParams()) { it.setReturnRef(it.target?.newBookMeta) }
                .function("slot",returns(Type.I).noParams()) { it.setReturnRef(it.target?.slot) }
                .function("setNewBookMeta",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnBookMeta.TYPE)) { it.target?.setNewBookMeta(it.getRef(0) as BookMeta) }
                .function("isSigning", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSigning ?: false) }
                .function("setSigning", returnsVoid().params(Type.Z)) { it.target?.setSigning(it.getBool(0)) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(PlayerEditBookEvent.getHandlerList()) }
        }
    }
}
