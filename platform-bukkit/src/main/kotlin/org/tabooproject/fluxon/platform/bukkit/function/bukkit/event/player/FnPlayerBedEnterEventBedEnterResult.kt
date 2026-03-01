package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.player.PlayerBedEnterEvent\$BedEnterResult"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerBedEnterEventBedEnterResult : FnEnumGetter<org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult>() {

    override val enumClass: Class<org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult> = org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult::class.java
}
