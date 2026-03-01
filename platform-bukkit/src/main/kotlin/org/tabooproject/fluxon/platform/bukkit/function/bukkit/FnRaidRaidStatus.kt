package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Raid
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.Raid\$RaidStatus"])
@PlatformSide(Platform.BUKKIT)
object FnRaidRaidStatus : FnEnumGetter<Raid.RaidStatus>() {

    override val enumClass: Class<Raid.RaidStatus> = Raid.RaidStatus::class.java
}
