package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.ItemFlag"])
@PlatformSide(Platform.BUKKIT)
object FnItemFlag : FnEnumGetter<org.bukkit.inventory.ItemFlag>() {

    override val enumClass: Class<org.bukkit.inventory.ItemFlag> = org.bukkit.inventory.ItemFlag::class.java
}
