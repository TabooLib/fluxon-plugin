package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.scoreboard.Team\$Option"])
@PlatformSide(Platform.BUKKIT)
object FnTeamOption : FnEnumGetter<org.bukkit.scoreboard.Team.Option>() {

    override val enumClass: Class<org.bukkit.scoreboard.Team.Option> = org.bukkit.scoreboard.Team.Option::class.java
}
