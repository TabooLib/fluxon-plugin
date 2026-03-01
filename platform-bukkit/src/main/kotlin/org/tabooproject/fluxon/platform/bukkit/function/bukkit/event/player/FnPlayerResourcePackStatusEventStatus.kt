package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.player.PlayerResourcePackStatusEvent\$Status"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerResourcePackStatusEventStatus : FnEnumGetter<org.bukkit.event.player.PlayerResourcePackStatusEvent.Status>() {

    override val enumClass: Class<org.bukkit.event.player.PlayerResourcePackStatusEvent.Status> = org.bukkit.event.player.PlayerResourcePackStatusEvent.Status::class.java
}
