package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryType
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryType\$SlotType"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryTypeSlotType : FnEnumGetter<InventoryType.SlotType>() {

    override val enumClass: Class<InventoryType.SlotType> = InventoryType.SlotType::class.java
}
