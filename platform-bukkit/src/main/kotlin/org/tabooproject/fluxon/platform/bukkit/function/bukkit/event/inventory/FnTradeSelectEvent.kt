package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.TradeSelectEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnMerchant
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnMerchantInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.TradeSelectEvent"])
@PlatformSide(Platform.BUKKIT)
object FnTradeSelectEvent {

    val TYPE = Type.fromClass(TradeSelectEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TradeSelectEvent::class.java)
                .function("index", returns(Type.I).noParams()) { it.setReturnRef(it.target?.index) }
                .function("inventory", returns(FnMerchantInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("merchant", returns(FnMerchant.TYPE).noParams()) { it.setReturnRef(it.target?.merchant) }
        }
    }
}
