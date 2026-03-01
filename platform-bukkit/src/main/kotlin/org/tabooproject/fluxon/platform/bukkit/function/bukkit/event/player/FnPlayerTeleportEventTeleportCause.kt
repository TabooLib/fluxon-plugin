package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.player.PlayerTeleportEvent\$TeleportCause"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerTeleportEventTeleportCause : FnEnumGetter<org.bukkit.event.player.PlayerTeleportEvent.TeleportCause>() {

    override val enumClass: Class<org.bukkit.event.player.PlayerTeleportEvent.TeleportCause> = org.bukkit.event.player.PlayerTeleportEvent.TeleportCause::class.java
}
