package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.player.PlayerSignOpenEvent\$Cause"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerSignOpenEventCause : FnEnumGetter<org.bukkit.event.player.PlayerSignOpenEvent.Cause>() {

    override val enumClass: Class<org.bukkit.event.player.PlayerSignOpenEvent.Cause> = org.bukkit.event.player.PlayerSignOpenEvent.Cause::class.java
}
