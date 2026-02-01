package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.EquipmentSlot
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.EquipmentSlot"])
@PlatformSide(Platform.BUKKIT)
object FnEquipmentSlot {

    val TYPE = Type.fromClass(EquipmentSlot::class.java)
}