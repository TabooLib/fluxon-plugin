package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.EquipmentSlot
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.EquipmentSlot"])
@PlatformSide(Platform.BUKKIT)
object FnEquipmentSlot : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.inventory.EquipmentSlot>() {

    override val enumClass: Class<org.bukkit.inventory.EquipmentSlot> = org.bukkit.inventory.EquipmentSlot::class.java

}