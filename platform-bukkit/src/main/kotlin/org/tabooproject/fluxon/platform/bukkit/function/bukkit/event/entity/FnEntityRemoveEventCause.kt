package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityRemoveEvent\$Cause"])
@PlatformSide(Platform.BUKKIT)
object FnEntityRemoveEventCause : FnEnumGetter<org.bukkit.event.entity.EntityRemoveEvent.Cause>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityRemoveEvent.Cause> = org.bukkit.event.entity.EntityRemoveEvent.Cause::class.java
}
