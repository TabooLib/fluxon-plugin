package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.player.PlayerFishEvent\$State"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerFishEventState : FnEnumGetter<org.bukkit.event.player.PlayerFishEvent.State>() {

    override val enumClass: Class<org.bukkit.event.player.PlayerFishEvent.State> = org.bukkit.event.player.PlayerFishEvent.State::class.java
}
