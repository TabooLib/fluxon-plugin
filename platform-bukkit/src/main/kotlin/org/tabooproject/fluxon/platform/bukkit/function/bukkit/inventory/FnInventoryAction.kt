package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.event.inventory.InventoryAction
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryAction"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryAction : FnEnumGetter<InventoryAction>() {

    override val enumClass: Class<InventoryAction> = InventoryAction::class.java
}
