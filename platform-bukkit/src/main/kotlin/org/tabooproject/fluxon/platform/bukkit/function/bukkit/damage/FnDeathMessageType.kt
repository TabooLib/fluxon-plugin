package org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.damage.DeathMessageType"])
@PlatformSide(Platform.BUKKIT)
object FnDeathMessageType : FnEnumGetter<org.bukkit.damage.DeathMessageType>() {

    override val enumClass: Class<org.bukkit.damage.DeathMessageType> = org.bukkit.damage.DeathMessageType::class.java
}
