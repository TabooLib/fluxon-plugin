package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.player.PlayerLoginEvent\$Result"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerLoginEventResult : FnEnumGetter<org.bukkit.event.player.PlayerLoginEvent.Result>() {

    override val enumClass: Class<org.bukkit.event.player.PlayerLoginEvent.Result> = org.bukkit.event.player.PlayerLoginEvent.Result::class.java
}
