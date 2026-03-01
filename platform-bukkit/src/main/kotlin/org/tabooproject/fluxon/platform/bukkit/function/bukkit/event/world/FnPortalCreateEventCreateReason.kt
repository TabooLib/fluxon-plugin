package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.world.PortalCreateEvent\$CreateReason"])
@PlatformSide(Platform.BUKKIT)
object FnPortalCreateEventCreateReason : FnEnumGetter<org.bukkit.event.world.PortalCreateEvent.CreateReason>() {

    override val enumClass: Class<org.bukkit.event.world.PortalCreateEvent.CreateReason> = org.bukkit.event.world.PortalCreateEvent.CreateReason::class.java
}
