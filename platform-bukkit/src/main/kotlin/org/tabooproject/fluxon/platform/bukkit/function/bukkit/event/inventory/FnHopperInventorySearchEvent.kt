package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.HopperInventorySearchEvent
import org.bukkit.inventory.Inventory
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.HopperInventorySearchEvent"])
@PlatformSide(Platform.BUKKIT)
object FnHopperInventorySearchEvent {

    val TYPE = Type.fromClass(HopperInventorySearchEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HopperInventorySearchEvent::class.java)
                .function("setInventory", returnsVoid().params(FnInventory.TYPE)) { it.target?.setInventory(it.getRef(0) as Inventory) }
                .function("inventory", returns(FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("containerType", returns(FnHopperInventorySearchEventContainerType.TYPE).noParams()) { it.setReturnRef(it.target?.containerType) }
                .function("searchBlock", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.searchBlock) }
        }
    }
}

@Requires(classes = ["org.bukkit.event.inventory.HopperInventorySearchEvent.ContainerType"])
@PlatformSide(Platform.BUKKIT)
object FnHopperInventorySearchEventContainerType : FnEnumGetter<HopperInventorySearchEvent.ContainerType>() {

    override val enumClass: Class<HopperInventorySearchEvent.ContainerType> = HopperInventorySearchEvent.ContainerType::class.java
}
