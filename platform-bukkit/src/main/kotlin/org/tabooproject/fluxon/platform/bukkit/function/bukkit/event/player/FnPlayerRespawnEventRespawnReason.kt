package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.player.PlayerRespawnEvent\$RespawnReason"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerRespawnEventRespawnReason : FnEnumGetter<org.bukkit.event.player.PlayerRespawnEvent.RespawnReason>() {

    override val enumClass: Class<org.bukkit.event.player.PlayerRespawnEvent.RespawnReason> = org.bukkit.event.player.PlayerRespawnEvent.RespawnReason::class.java
}
