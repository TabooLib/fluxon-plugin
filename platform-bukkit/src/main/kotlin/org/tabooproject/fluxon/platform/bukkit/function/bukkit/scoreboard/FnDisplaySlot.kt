package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.scoreboard.DisplaySlot"])
@PlatformSide(Platform.BUKKIT)
object FnDisplaySlot : FnEnumGetter<org.bukkit.scoreboard.DisplaySlot>() {

    override val enumClass: Class<org.bukkit.scoreboard.DisplaySlot> = org.bukkit.scoreboard.DisplaySlot::class.java
}
