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
                .function("previousBookMeta", returnsObject().noParams()) { it.setReturnRef(it.target?.previousBookMeta) }
                .function("newBookMeta", returnsObject().noParams()) { it.setReturnRef(it.target?.newBookMeta) }
                .function("slot", returnsObject().noParams()) { it.setReturnRef(it.target?.slot) }
                .function("setNewBookMeta", returnsVoid().params(Type.OBJECT)) { it.target?.setNewBookMeta(it.getRef(0) as BookMeta) }
                .function("isSigning", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSigning ?: false) }
                .function("setSigning", returnsVoid().params(Type.Z)) { it.target?.setSigning(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerEditBookEvent.getHandlerList()) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
        }
    }
}
