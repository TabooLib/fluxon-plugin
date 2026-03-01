package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.world.TimeSkipEvent\$SkipReason"])
@PlatformSide(Platform.BUKKIT)
object FnTimeSkipEventSkipReason : FnEnumGetter<org.bukkit.event.world.TimeSkipEvent.SkipReason>() {

    override val enumClass: Class<org.bukkit.event.world.TimeSkipEvent.SkipReason> = org.bukkit.event.world.TimeSkipEvent.SkipReason::class.java
}
