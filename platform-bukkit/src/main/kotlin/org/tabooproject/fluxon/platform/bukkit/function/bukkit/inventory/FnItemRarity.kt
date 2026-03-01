package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.ItemRarity"])
@PlatformSide(Platform.BUKKIT)
object FnItemRarity : FnEnumGetter<org.bukkit.inventory.ItemRarity>() {

    override val enumClass: Class<org.bukkit.inventory.ItemRarity> = org.bukkit.inventory.ItemRarity::class.java
}
