package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.scoreboard.Team
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.scoreboard.Team\$OptionStatus"])
@PlatformSide(Platform.BUKKIT)
object FnTeamOptionStatus : FnEnumGetter<Team.OptionStatus>() {

    override val enumClass: Class<Team.OptionStatus> = Team.OptionStatus::class.java
}
