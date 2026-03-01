package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.weather

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.weather.LightningStrikeEvent\$Cause"])
@PlatformSide(Platform.BUKKIT)
object FnLightningStrikeEventCause : FnEnumGetter<org.bukkit.event.weather.LightningStrikeEvent.Cause>() {

    override val enumClass: Class<org.bukkit.event.weather.LightningStrikeEvent.Cause> = org.bukkit.event.weather.LightningStrikeEvent.Cause::class.java
}
