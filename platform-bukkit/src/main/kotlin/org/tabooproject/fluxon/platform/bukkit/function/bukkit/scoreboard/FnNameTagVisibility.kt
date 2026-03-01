package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.scoreboard.NameTagVisibility"])
@PlatformSide(Platform.BUKKIT)
object FnNameTagVisibility : FnEnumGetter<org.bukkit.scoreboard.NameTagVisibility>() {

    override val enumClass: Class<org.bukkit.scoreboard.NameTagVisibility> = org.bukkit.scoreboard.NameTagVisibility::class.java
}
