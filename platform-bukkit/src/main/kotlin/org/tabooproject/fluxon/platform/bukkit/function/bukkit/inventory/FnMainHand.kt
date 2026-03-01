package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.MainHand"])
@PlatformSide(Platform.BUKKIT)
object FnMainHand : FnEnumGetter<org.bukkit.inventory.MainHand>() {

    override val enumClass: Class<org.bukkit.inventory.MainHand> = org.bukkit.inventory.MainHand::class.java
}
