package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.GrindstoneInventory
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.GrindstoneInventory"])
@PlatformSide(Platform.BUKKIT)
object FnGrindstoneInventory {

    val TYPE = Type.fromClass(GrindstoneInventory::class.java)
}
