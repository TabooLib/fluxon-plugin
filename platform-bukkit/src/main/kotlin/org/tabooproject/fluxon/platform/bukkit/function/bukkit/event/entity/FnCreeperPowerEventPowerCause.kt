package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.CreeperPowerEvent\$PowerCause"])
@PlatformSide(Platform.BUKKIT)
object FnCreeperPowerEventPowerCause : FnEnumGetter<org.bukkit.event.entity.CreeperPowerEvent.PowerCause>() {

    override val enumClass: Class<org.bukkit.event.entity.CreeperPowerEvent.PowerCause> = org.bukkit.event.entity.CreeperPowerEvent.PowerCause::class.java
}
