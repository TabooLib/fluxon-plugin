package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.CreativeCategory"])
@PlatformSide(Platform.BUKKIT)
object FnCreativeCategory : FnEnumGetter<org.bukkit.inventory.CreativeCategory>() {

    override val enumClass: Class<org.bukkit.inventory.CreativeCategory> = org.bukkit.inventory.CreativeCategory::class.java
}
