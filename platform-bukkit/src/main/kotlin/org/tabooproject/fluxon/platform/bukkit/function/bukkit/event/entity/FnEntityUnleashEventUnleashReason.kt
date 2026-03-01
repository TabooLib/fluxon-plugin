package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityUnleashEvent\$UnleashReason"])
@PlatformSide(Platform.BUKKIT)
object FnEntityUnleashEventUnleashReason : FnEnumGetter<org.bukkit.event.entity.EntityUnleashEvent.UnleashReason>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityUnleashEvent.UnleashReason> = org.bukkit.event.entity.EntityUnleashEvent.UnleashReason::class.java
}
