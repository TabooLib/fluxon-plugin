package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.player.PlayerAnimationType"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerAnimationType : FnEnumGetter<org.bukkit.event.player.PlayerAnimationType>() {

    override val enumClass: Class<org.bukkit.event.player.PlayerAnimationType> = org.bukkit.event.player.PlayerAnimationType::class.java
}
